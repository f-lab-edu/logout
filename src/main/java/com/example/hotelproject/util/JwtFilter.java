//package com.example.hotelproject.util;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final JwtProvider jwtProvider;
//
//    public JwtFilter(JwtProvider jwtProvider) {
//        this.jwtProvider = jwtProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//        throws ServletException, IOException {
//        //헤더에서 토큰 받아오기
//        String token = jwtProvider.resolveToken(request);
//
//        if (jwtProvider.validateToken(token)) {
//            // 토큰이 유효하면 토큰으로부터 유저 정보를 받아옴
//            Authentication authentication = jwtProvider.getAuthentication(token);
//            // SecurityContext 에 Authentication 객체를 저장
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
