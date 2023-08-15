//package com.example.hotelproject.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.authority.AuthorityUtils;
//
//@Slf4j
//@Getter
//@Setter
//public class SecurityUser extends org.springframework.security.core.userdetails.User {
//
//    private User member;
//
//    public SecurityUser(User member) {
//        super(member.getName(), member.getPassword(), AuthorityUtils
//            .createAuthorityList(member.getRole().toString()));
//
//        log.info("SecurityUser member.username = {}", member.getName());
//        log.info("SecurityUser member.password = {}", member.getPassword());
//        log.info("SecurityUser member.role = {}", member.getRole().toString());
//
//        this.member = member;
//    }
//
//}
