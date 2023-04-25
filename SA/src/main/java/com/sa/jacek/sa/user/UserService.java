package com.sa.jacek.sa.user;

import com.sa.jacek.sa.exception.IdMismatchException;
import com.sa.jacek.sa.exception.ResourceNotFoundException;
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


        public UserDto getById(Long id) {
            return userMapper.mapToDto(userRepository.findById(id).orElse(null));
        }

    public UserDto updateUser(Long id, UserDto dto) {
        Assert.notNull(dto.getId(), "Id cannot be empty");
        if (!dto.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");   // porónuje id ze ścieżki z adresu z id w body. Jeśli adresy są tożsame to aktualizacja się wykona.
        }
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User doesn't exist"); // czy użytkownik do update o podanym id istnieje. bez tego wyjątku zakłada nowego id zamiast aktualizować
        }
        User entity = userMapper.mapToEntity(dto);
        userRepository.save(entity);
        return userMapper.mapToDto(entity);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
