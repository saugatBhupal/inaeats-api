package com.inaing.inaeats.dto.otp;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public final class OtpValidationDto {
    private String phone;
    private String otp;

}
