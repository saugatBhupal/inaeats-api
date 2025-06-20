package com.inaing.inaeats.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnregisteredUserWithTokenDto {

    private String id;
    private String phone;
    private String jwt;
}
