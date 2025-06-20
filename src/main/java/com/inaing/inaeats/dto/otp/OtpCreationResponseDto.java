package com.inaing.inaeats.dto.otp;

import java.time.LocalDateTime;

import lombok.Value;

@Value
public final class OtpCreationResponseDto {
    private final String message;
    private final String expiryTime;

    public OtpCreationResponseDto(String message, LocalDateTime expiryTime) {
        this.message = message;
        this.expiryTime = expiryTime.toString();
    }
}
