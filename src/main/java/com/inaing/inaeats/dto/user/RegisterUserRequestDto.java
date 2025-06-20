package com.inaing.inaeats.dto.user;

import java.sql.Date;

import com.inaing.inaeats.entity.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserRequestDto {
    private String fullname;
    private String phone;
    private String email;
    private Gender gender;
    private Date dob;
}
