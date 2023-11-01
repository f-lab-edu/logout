package com.example.hotelproject.sign;

import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.member.repository.MemberRepository;
import com.example.hotelproject.security.JwtProvider;
import com.example.hotelproject.security.MemberRoleEnum;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignService(MemberRepository memberRepository, PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Transactional
    public SignResponse login(SignRequest request) {
        Member member = memberRepository.findMemberByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("잘못된 이메일입니다."));

        if (passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new IllegalStateException("잘못된 비밀번호 입니다.");
        }

        SignResponse result = SignResponse.of(member);

        List<String> roles = new ArrayList<>();
        roles.add(member.getRole().name());
        result.setToken(jwtProvider.createToken(member.getEmail(), roles));

        return result;
    }

    @Transactional
    public SignResponse join(SignRequest request) {
        try {
            if (memberRepository.existsByEmail(request.getEmail())) {
                throw new EntityExistsException("이미 가입된 이메일입니다.");
            }

            String password = passwordEncoder.encode(request.getPassword());
            Member member = request.toMember(password, MemberRoleEnum.USER);

            memberRepository.save(member);
        } catch (Exception e) {
            throw new IllegalStateException("가입에 실패하였습니다.");
        }

        Member joinMember = memberRepository.findMemberByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        return SignResponse.of(joinMember);
    }
}
