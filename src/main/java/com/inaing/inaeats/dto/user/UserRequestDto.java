package com.inaing.inaeats.dto.user;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDto {
    private String phone;

    @Nullable
    private String id;

    public UserRequestDto(String phone) {
        this.phone = phone;
        this.id = null;
    }
}
