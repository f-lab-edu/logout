package com.example.hotelproject.sign;

import com.example.hotelproject.security.JwtProvider;
import com.example.hotelproject.security.UserRoleEnum;
import com.example.hotelproject.user.entity.User;
import com.example.hotelproject.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Transactional
    public SignResponse login(SignRequest request) {
        User user = userRepository.findUserByUserId(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("잘못된 아이디입니다."));

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalStateException("잘못된 비밀번호 입니다.");
        }

        SignResponse result = SignResponse.of(user);

        List<String> roles = new ArrayList<>();
        roles.add(user.getRole().name());
        result.setToken(jwtProvider.createToken(user.getUserId(), roles));

        return result;
    }

    @Transactional
    public SignResponse join(SignRequest request) {
        try {
            if (userRepository.existsByUserId(request.getUserId())) {
                throw new EntityExistsException("이미 가입된 아이디입니다.");
            }

            String password = passwordEncoder.encode(request.getPassword());
            User user = request.toUser(password, UserRoleEnum.USER);

            userRepository.save(user);
        } catch (Exception e) {
            throw new IllegalStateException("가입에 실패하였습니다.");
        }

        User joinMember = userRepository.findUserByUserId(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        return SignResponse.of(joinMember);
    }
}
