package com.sa.jacek.sa.user;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
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
    private String login;
    private String email;
    private String password;
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

