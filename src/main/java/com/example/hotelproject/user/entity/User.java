package com.example.hotelproject.user.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.hotelproject.util.entity.BaseDateTimeEntity;
import lombok.*;


//table 1:1
//create basic select update DB 작업에 사용
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들어줌
@ToString
@Entity(name = "user") //JPA를 사용할 클래스를 명시하며, 테이블과 매핑하는 역할을 한다.
public class User extends BaseDateTimeEntity {

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

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "enabled")
    private boolean enabled;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    public User(Long userNo, String userId, String name, String password, String email, int age,
        String address, String mobile, boolean enabled) {
        this.userNo = userNo;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.address = address;
        this.mobile = mobile;
        this.enabled = enabled;
    }
}
