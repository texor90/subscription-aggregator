package com.sa.jacek.sa.user;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {

    User mapToEntity(UserDto dto);

    UserDto mapToDto(User user);

    List<UserDto> mapToDto(List<User> users);
}
