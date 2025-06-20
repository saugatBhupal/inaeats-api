package com.inaing.inaeats.dto.otp;

import java.time.LocalDateTime;

import lombok.Value;

@Value
public final class OtpCreationRequestDto {
    private String phone;
    private LocalDateTime requestTime;

    public OtpCreationRequestDto(String phone) {
        this.phone = phone;
        this.requestTime = LocalDateTime.now();
    }
}
