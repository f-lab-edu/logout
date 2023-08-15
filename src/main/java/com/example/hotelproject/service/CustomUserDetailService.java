//package com.example.hotelproject.service;
//
//import com.example.hotelproject.domain.User;
//import com.example.hotelproject.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    public CustomUserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUserId(userId)
//            .orElseThrow(()-> new UsernameNotFoundException(userId));
//
//        return org.springframework.security.core.userdetails.User.builder()
//            .username(user.getUserId())
//            .password(user.getPassword())
//            .roles(String.valueOf(user.getRole()))
//            .build();
//
//    }
//
//
//}
