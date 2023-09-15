//package com.example.hotelproject.config;
//
//import com.example.hotelproject.util.JwtFilter;
//import com.example.hotelproject.util.JwtProvider;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity        //spring security 를 적용한다는 Annotation
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private JwtProvider jwtProvider;
//
//    public WebSecurityConfig(JwtProvider jwtProvider) {
//        this.jwtProvider = jwtProvider;
//    }
//
//    @Bean
//    @Order(SecurityProperties.BASIC_AUTH_ORDER)
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .httpBasic().disable()// rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
//            .csrf().disable().headers().frameOptions().disable() // rest api이므로 csrf 보안이 필요없으므로 disable처리.
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // jwt token으로 인증할것이므로 세션필요없으므로 생성안함.
//            .and()
//            .authorizeHttpRequests(auth ->
//                auth.antMatchers("api/v1/users/**", "api/v1/owners/**").permitAll())
////            .authorizeRequests()
////                .mvcMatchers("api/v1/users/**").hasRole("USER")
////                .mvcMatchers("api/v1/owners/**").hasRole("OWNER")
////                .anyRequest().authenticated()
////            .and()
////            .addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class); // UsernamePasswordAuthenticationFilter 전에 JwtAuthenticationFilter 삽입
//                ;
////            .logout()
////            .invalidateHttpSession(true)
//
//        return http.build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//
//}
// 얘도 마찬가지로 안쓰면 지워두는게 좋을 것 같아요 ~ 당장 쓰지 않는 코드에 미련갖지 마세요!