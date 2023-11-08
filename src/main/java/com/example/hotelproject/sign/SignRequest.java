package com.example.hotelproject.sign;

import com.example.hotelproject.member.entity.Member;
import com.example.hotelproject.security.MemberRoleEnum;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignRequest {

    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
    private String password;

    private MemberRoleEnum role;

    @Builder
    public SignRequest(String email, String password, MemberRoleEnum role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Member toMember(String password, MemberRoleEnum role) {
        return Member.builder()
                .email(email)
                .password(password)
                .role(role)
                .build();
    }
}
