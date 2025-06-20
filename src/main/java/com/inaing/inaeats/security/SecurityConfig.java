package com.inaing.inaeats.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.inaing.inaeats.security.jwtFilter.JwtAuthenticationFilter;
import com.inaing.inaeats.security.otpFilter.OtpAuhenticationProvider;
import com.inaing.inaeats.security.otpFilter.OtpAuthenticationFilter;
import com.inaing.inaeats.service.UserService;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
@Slf4j
public class SecurityConfig {

        private final OtpAuhenticationProvider otpAuhenticationProvider;
        private final JwtAuthenticationFilter jwtAuthenticationFilter;
        private final UserService userService;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
                authBuilder.authenticationProvider(otpAuhenticationProvider);
                AuthenticationManager authenticationManager = authBuilder.build();
                OtpAuthenticationFilter otpAuthenticationFilter = new OtpAuthenticationFilter(authenticationManager,
                                userService);
                http.csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("api/v1/otp/send", "api/v1/login/otp").permitAll()
                                                .anyRequest().authenticated())
                                .sessionManagement(management -> management
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationManager(authenticationManager)
                                .addFilterBefore(otpAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }

        @PostConstruct
        public void onInit() {
                log.info("SecurityConfig has been constructed and initialized.");
        }
}
