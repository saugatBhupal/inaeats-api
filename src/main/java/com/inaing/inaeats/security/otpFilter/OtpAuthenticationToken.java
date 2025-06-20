package com.inaing.inaeats.security.otpFilter;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class OtpAuthenticationToken extends AbstractAuthenticationToken {

    private final String phone;
    private final String otp;

    public OtpAuthenticationToken(String phone, String otp) {
        super(null);
        this.phone = phone;
        this.otp = otp;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return otp;
    }

    @Override
    public Object getPrincipal() {
        return phone;
    }

}
