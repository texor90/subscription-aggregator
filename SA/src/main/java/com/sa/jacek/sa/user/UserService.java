package com.sa.jacek.sa.user;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAll() {
        return userMapper.mapToDto(userRepository.findAll());
    }

    public UserDto addUser(UserDto dto) {
        User User = userMapper.mapToEntity(dto);
        Assert.isNull(User.getId(), "Id has to be null");
        userRepository.save(User);
        return userMapper.mapToDto(User);
    }

}
