package de.yasamin.lernkarteiprojekt;

import de.yasamin.lernkarteiprojekt.model.Karte;
import de.yasamin.lernkarteiprojekt.model.LernGruppe;
import de.yasamin.lernkarteiprojekt.model.Status;
import de.yasamin.lernkarteiprojekt.repository.KarteRepository;
import de.yasamin.lernkarteiprojekt.repository.LernGruppeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class LernKarteiProjektApplication implements WebMvcConfigurer,CommandLineRunner {

    private final LernGruppeRepository lernGruppeRepository;
    private final KarteRepository karteRepository;


    public static void main(String[] args) {

        SpringApplication.run(LernKarteiProjektApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//Beispiele
/*
       var lerngruppe = LernGruppe.builder()
               .title("Matematik")
               .build();
       lernGruppeRepository.save(lerngruppe);

        var lerngruppe2 = LernGruppe.builder()
                .title("Sprache")
                .build();
        lernGruppeRepository.save(lerngruppe2);

        var lerngruppe3 = LernGruppe.builder()
                .title("Maschinenbau")
                .build();
        lernGruppeRepository.save(lerngruppe3);

        var karte = Karte.builder()
                .lernGruppe(lerngruppe)
                .frage("Frage 1")
                .antwort("Antwort 1")
                .status(Status.NEU)
                .date(LocalDate.now())
                .build();
        karteRepository.save(karte);

        var karte2 = Karte.builder()
                .lernGruppe(lerngruppe)
                .frage("Frage 2")
                .antwort("Antwort 2")
                .status(Status.NEU)
                .date(LocalDate.now())
                .build();
        karteRepository.save(karte2);

        var karte3 = Karte.builder()
                .lernGruppe(lerngruppe2)
                .frage("Frage 3")
                .antwort("Antwort 3")
                .status(Status.NEU)
                .date(LocalDate.now())
                .build();
        karteRepository.save(karte3);

        var karte4 = Karte.builder()
                .lernGruppe(lerngruppe2)
                .frage("Frage 4")
                .antwort("Antwort 4")
                .status(Status.NEU)
                .date(LocalDate.now())
                .build();
        karteRepository.save(karte4);

        var karte5 = Karte.builder()
                .lernGruppe(lerngruppe2)
                .frage("Frage 5")
                .antwort("Antwort 5")
                .status(Status.NEU)
                .date(LocalDate.now())
                .build();
        karteRepository.save(karte5);

        var karte6 = Karte.builder()
                .lernGruppe(lerngruppe2)
                .frage("Frage 6")
                .antwort("Antwort 6")
                .status(Status.NEU)
                .date(LocalDate.now())
                .build();
        karteRepository.save(karte6);*/
    }
}
