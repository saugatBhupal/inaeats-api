package com.inaing.inaeats.controller.public_access;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inaing.inaeats.dto.otp.OtpCreationRequestDto;
import com.inaing.inaeats.dto.otp.OtpCreationResponseDto;
import com.inaing.inaeats.response.RestStandardResponse;
import com.inaing.inaeats.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/otp/send")
    public ResponseEntity<?> getOtp(@RequestBody OtpCreationRequestDto otpCreationRequestDto) {
        OtpCreationResponseDto otpCreationResponseDto = userService.sendOtp(otpCreationRequestDto);
        RestStandardResponse<OtpCreationResponseDto> response = new RestStandardResponse<OtpCreationResponseDto>(200,
                otpCreationResponseDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hello")
    public String hello() {
        return new String("hello");
    }

}
