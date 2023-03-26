package de.yasamin.lernkarteiprojekt.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Karte> karten = new ArrayList<>();

}


