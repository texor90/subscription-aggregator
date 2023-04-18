package com.sa.jacek.sa.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String login;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
}
