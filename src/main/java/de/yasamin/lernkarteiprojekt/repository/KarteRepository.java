package de.yasamin.lernkarteiprojekt.repository;

import de.yasamin.lernkarteiprojekt.model.Karte;
import de.yasamin.lernkarteiprojekt.model.LernGruppe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface KarteRepository extends JpaRepository<Karte, Long> {

    List<Karte> findAllByLernGruppeAndDate(LernGruppe lernGruppe, LocalDate date);
    List<Karte> findAllByLernGruppe(LernGruppe lernGruppe);
    List<Karte> findAllByLerncount(int count);
}
