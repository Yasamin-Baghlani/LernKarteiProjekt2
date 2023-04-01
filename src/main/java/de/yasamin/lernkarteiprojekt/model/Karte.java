package de.yasamin.lernkarteiprojekt.model;


import javax.management.ConstructorParameters;
import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Karte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 800)
    private String frage;

    @Column(length = 800)
    private String antwort;

    @ManyToOne
    private LernGruppe lernGruppe;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate date;

    private int lerncount;


}
