package com.example.hotelproject.member.entity;

import com.example.hotelproject.security.MemberRoleEnum;
import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@Entity(name = "member")
public class Member extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "enabled")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    private MemberRoleEnum role;

    @Column(name = "nickname")
    private String nickname;

    @Builder
    public Member(Long memberId, String name, String password, String email, int age,
            String address, String mobile, boolean enabled, MemberRoleEnum role,
            String nickname) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.address = address;
        this.mobile = mobile;
        this.enabled = enabled;
        this.role = role;
        this.nickname = nickname;
    }
}
