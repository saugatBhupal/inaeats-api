package com.inaing.inaeats.security.otpFilter;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.inaing.inaeats.dto.otp.OtpValidationDto;
import com.inaing.inaeats.exception.RestStandardException;
import com.inaing.inaeats.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class OtpAuhenticationProvider implements AuthenticationProvider {

    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String phone = authentication.getPrincipal().toString();
        String otp = authentication.getCredentials().toString();
        OtpValidationDto otpValidationRequestDto = new OtpValidationDto(phone, otp);

        try {
            userService.validateOtp(otpValidationRequestDto);
            log.info("Authenticated");
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    phone, otp, List.of(new SimpleGrantedAuthority("ROLE_USER")));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            return usernamePasswordAuthenticationToken;
        } catch (RestStandardException exception) {
            log.info("OTP Auth failed.");
            throw new BadCredentialsException(exception.getMessage());
        }
    }

    @Override

    public boolean supports(Class<?> authentication) {
        return OtpAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
