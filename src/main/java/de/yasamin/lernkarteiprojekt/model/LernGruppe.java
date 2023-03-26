package de.yasamin.lernkarteiprojekt.model;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LernGruppe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;

    @Column(length = 100)
    private String title;

    @OneToMany(mappedBy = "lernGruppe")
    private List<Karte> karten;


    public void addKarte(Karte karte) {

        if(karten == null)
            karten = new ArrayList<>();

        if(!karten.contains(karte)) {
            karten.add(karte);
            karte.setLernGruppe(this);
        }
    }


}
