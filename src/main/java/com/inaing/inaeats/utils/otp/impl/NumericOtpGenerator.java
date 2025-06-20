package com.inaing.inaeats.utils.otp.impl;

import java.security.SecureRandom;

import com.inaing.inaeats.utils.otp.StringGenerator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NumericOtpGenerator implements StringGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();
    private final int otpLength;

    @Override
    public String generate() {
        int max = (int) Math.pow(10, otpLength);
        int otp = secureRandom.nextInt(max);
        return String.format("%0" + otpLength + "d", otp);
    }

}
