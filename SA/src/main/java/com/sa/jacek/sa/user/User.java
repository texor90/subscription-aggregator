package com.sa.jacek.sa.user;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            return Objects.equals(id, user.id);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

