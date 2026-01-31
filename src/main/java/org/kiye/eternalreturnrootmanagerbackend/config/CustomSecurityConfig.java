package org.kiye.eternalreturnrootmanagerbackend.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // REST API 테스트면 보통 끔
                .csrf(csrf -> csrf.disable())

                // 세션 안 쓰는 방향 (나중에 JWT 붙일 때도 동일)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // ★ 여기서 테스트 API를 열어준다
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/characters/**").permitAll()
                        .anyRequest().permitAll()   // 일단 전부 열기(테스트용)
                )

                // 기본 로그인폼 끄기 (REST에서 불필요)
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
