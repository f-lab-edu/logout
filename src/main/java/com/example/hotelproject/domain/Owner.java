package com.example.hotelproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@Entity(name = "USER_OWNER")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "enabled")
    private boolean enabled;

    public Owner(Long userNo, String userId, String name, String password, String email,
        String address, String mobile, boolean enabled) {
        this.userNo = userNo;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.enabled = enabled;
    }
}
