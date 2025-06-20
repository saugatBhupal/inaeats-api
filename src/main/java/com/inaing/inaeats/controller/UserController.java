package com.inaing.inaeats.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inaing.inaeats.dto.user.BasicUserDetailsWithTokenDto;
import com.inaing.inaeats.dto.user.RegisterUserRequestDto;
import com.inaing.inaeats.response.RestStandardResponse;
import com.inaing.inaeats.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> resgiterUser(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
        BasicUserDetailsWithTokenDto basicUserDetailsWithTokenDto = userService.register(registerUserRequestDto);
        RestStandardResponse<BasicUserDetailsWithTokenDto> response = new RestStandardResponse<BasicUserDetailsWithTokenDto>(
                200, basicUserDetailsWithTokenDto);
        return ResponseEntity.ok().body(response);
    }

}
