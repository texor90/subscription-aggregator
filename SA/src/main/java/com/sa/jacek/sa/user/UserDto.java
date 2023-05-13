package com.sa.jacek.sa.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class UserDto {

    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String login;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 10)
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull
    @Past
    private LocalDate dateOfBirth;
}

