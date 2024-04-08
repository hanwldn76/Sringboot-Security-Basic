package com.cos.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig{
    // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // 사이트 위변조 요청 방지
        http
                .csrf((auth) -> auth.disable());

        http
                .authorizeHttpRequests((auth) -> auth
                        // user -> 인증만 되면 들어가는 주소
                        // manager -> user나 admin 권한이 있어야 들어가는 주소
                        // admin -> admin 권한이 있어야 들어가는 주소
                        .requestMatchers("/user/**").authenticated()
                        .requestMatchers("/manager/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                );

        http
                .formLogin((auth) -> auth.loginPage("/loginForm")
                        // /login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인을 진행
                        // -> 즉, 컨트롤러에 /login을 만들 필요가 없음
                        .loginProcessingUrl("/login")
                        // 로그인이 끝나면 리다이렉트할 url
                        .defaultSuccessUrl("/")
                        // 정리
                        // /loginFrom -> /login 해서 로그인이 되면 / 로 이동
                        // /user -> /login 해서 로그인이 되면 /user로 이동
                );

        return http.build();
    }

}
