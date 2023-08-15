//package com.example.hotelproject.util;
//
//import com.example.hotelproject.domain.Role;
//import com.example.hotelproject.domain.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.util.Base64;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//@RequiredArgsConstructor
//@Component
//public class JwtProvider {
//
//    @Value("${jwt.token.secret}")
//    private String secretkey;
//    private long tokenValidTime  = 1000 * 60 * 60 * 24 * 7; // 토큰 7일
//
//    /** Security UserDetailsService */
//    private final UserDetailsService userDetailsService;
//
//
//    // 객체 초기화
//    @PostConstruct
//    protected void init() {
//        secretkey = Base64.getEncoder().encodeToString(secretkey.getBytes());
//        System.err.println(String.format("secretKey = %s", secretkey));
//    }
//
//    // JWT 토큰 생성
//    public String createTokenByRole(String userPk, Role role) {
//        Claims claims = Jwts.claims().setSubject(userPk); // JWT payload 에 저장되는 정보단위
//        claims.put("roles", role); // 정보는 key / value 쌍으로 저장된다.
//        Date now = new Date();
//        return Jwts.builder()
//            .setClaims(claims) // 정보 저장
//            .setIssuedAt(now) // 토큰 발행 시간 정보
//            .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
//            .signWith(SignatureAlgorithm.HS256, secretkey)  // 사용할 암호화 알고리즘과
//            // signature 에 들어갈 secret값 세팅
//            .compact();
//    }
//
//    public static String createToken(String userId, long expireTimeMs, String key) {
//        Claims claims = Jwts.claims();
//        claims.put("userId", userId);
//
//        return Jwts.builder()
//            .setClaims(claims)
//            .setIssuedAt(new Date(System.currentTimeMillis()))
//            .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
//            .signWith(SignatureAlgorithm.HS256, key)
//            .compact();
//    }
//
//    public String updateToken(User user) {
//        Claims claims = Jwts.claims().setSubject(user.getUserId());
//        claims.put("roles", user.getRole());
//
//        return Jwts.builder()
//            .setClaims(claims)
//            .setIssuedAt(new Date(System.currentTimeMillis()))
//            .setExpiration(new Date(System.currentTimeMillis() + tokenValidTime))
//            .signWith(SignatureAlgorithm.HS256, secretkey)
//            .compact();
//    }
//
//    // JWT 토큰에서 인증 정보 조회
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    // 토큰에서 회원 정보 추출
//    public String getUserPk(String token) {
//        return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    // Request의 Header에서 token 값을 가져옵니다. "X-AUTH-TOKEN" : "TOKEN값'
//    public String resolveToken(HttpServletRequest request) {
//        return request.getHeader("X-AUTH-TOKEN");
//    }
//
//    // 토큰의 유효성 + 만료일자 확인
//    public boolean validateToken(String jwtToken) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretkey).parseClaimsJws(jwtToken);
//            return !claims.getBody().getExpiration().before(new Date(System.currentTimeMillis()));
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}