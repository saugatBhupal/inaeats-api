package com.inaing.inaeats.mapper;

import org.mapstruct.Mapper;

import com.inaing.inaeats.dto.user.BasicUserDetailsWithTokenDto;
import com.inaing.inaeats.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    BasicUserDetailsWithTokenDto tobaBasicUserDetailsWithTokenDto(User user);
}
