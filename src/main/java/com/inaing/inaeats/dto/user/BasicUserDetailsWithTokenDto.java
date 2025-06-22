package com.inaing.inaeats.dto.user;

import java.sql.Date;

import com.inaing.inaeats.entity.enums.DifficultyType;
import com.inaing.inaeats.entity.enums.Gender;
import com.inaing.inaeats.entity.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicUserDetailsWithTokenDto {
    private String id;
    private String fullname;
    private String email;
    private String phone;
    private Gender gender;
    private Date dob;
    private Integer age;
    private UserType userType;
    private Boolean hasRegistered;
    private String token;
    private String recipeVideo;
    private Integer duration;
    private DifficultyType difficultyType;
}
