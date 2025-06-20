package com.inaing.inaeats.service;

import com.inaing.inaeats.dto.otp.OtpCreationRequestDto;
import com.inaing.inaeats.dto.otp.OtpCreationResponseDto;
import com.inaing.inaeats.dto.otp.OtpValidationDto;
import com.inaing.inaeats.dto.user.BasicUserDetailsWithTokenDto;
import com.inaing.inaeats.dto.user.RegisterUserRequestDto;
import com.inaing.inaeats.dto.user.UserRequestDto;

public interface UserService {
    public BasicUserDetailsWithTokenDto register(RegisterUserRequestDto registerUserRequestDto);

    public OtpCreationResponseDto sendOtp(OtpCreationRequestDto otpCreationRequestDto);

    public void validateOtp(OtpValidationDto otpValidationDto);

    public BasicUserDetailsWithTokenDto getBasicUserDetailsWithTOken(UserRequestDto userRequestDto);
}
