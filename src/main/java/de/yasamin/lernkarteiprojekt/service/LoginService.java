package de.yasamin.lernkarteiprojekt.service;

import de.yasamin.lernkarteiprojekt.model.User;
import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginService implements Serializable {

    private User user;


    public void doLogIn(User user) {
        this.user = user;
    }

    public void doLogOut() {
        this.user = null;
    }

    public boolean isLoggedIn() {
        return this.user != null;
    }
}
