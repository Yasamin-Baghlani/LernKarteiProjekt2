package de.yasamin.lernkarteiprojekt.service;

import de.yasamin.lernkarteiprojekt.model.Karte;
import de.yasamin.lernkarteiprojekt.repository.KarteRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class KarteService implements Serializable {
  private List<Karte> karten = new ArrayList<>();




    public List<Karte> getAntwort() {

        return Collections.unmodifiableList(karten);

    }

}
