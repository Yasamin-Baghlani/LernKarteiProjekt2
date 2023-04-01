package de.yasamin.lernkarteiprojekt.repository;

import de.yasamin.lernkarteiprojekt.model.Karte;
import de.yasamin.lernkarteiprojekt.model.LernGruppe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LernGruppeRepository extends JpaRepository<LernGruppe, Long> {

    Optional<LernGruppe> findAllByTitle(String title);

}
