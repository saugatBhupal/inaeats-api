package com.inaing.inaeats.security.otpFilter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inaing.inaeats.dto.user.BasicUserDetailsWithTokenDto;
import com.inaing.inaeats.dto.user.UserRequestDto;
import com.inaing.inaeats.response.RestStandardResponse;
import com.inaing.inaeats.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtpAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public OtpAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/api/v1/otp/login");
        setAuthenticationFailureHandler(new OtpAuthenticationFailureHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String otp = request.getParameter("otp");
        OtpAuthenticationToken authRequest = new OtpAuthenticationToken(phone, otp);
        return authenticationManager.authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        log.info("OTP Authentication successful for user: {}", authResult.getName());
        BasicUserDetailsWithTokenDto user = userService
                .getBasicUserDetailsWithTOken(new UserRequestDto(authResult.getName()));
        SecurityContextHolder.getContext().setAuthentication(authResult);
        RestStandardResponse<BasicUserDetailsWithTokenDto> restResponse = new RestStandardResponse<BasicUserDetailsWithTokenDto>(
                200, user);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getWriter(), restResponse);
    }
}
