package de.yasamin.lernkarteiprojekt.controller;

import de.yasamin.lernkarteiprojekt.model.Karte;
import de.yasamin.lernkarteiprojekt.model.Status;
import de.yasamin.lernkarteiprojekt.repository.KarteRepository;
import de.yasamin.lernkarteiprojekt.repository.LernGruppeRepository;
import de.yasamin.lernkarteiprojekt.service.KarteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
@CrossOrigin
@Transactional
public class KarteController {
    private final KarteRepository karteRepository;

    private final LernGruppeRepository lerngrupperepository;

    private  Optional<Karte>  karten = null;


    @GetMapping
    public String index(Model model){
        model.addAttribute("col1","90 % der Schüler, die mit Karteikarten lernen, berichten von besseren Noten.");
        model.addAttribute("col2","Gestalte schwierige Themen mit Karteikarten einfacher");
        return "start";
    }

    @GetMapping("karte")
    public String list(Karte karte,Model model){
        model.addAttribute("karte", karteRepository.findAllByDate(LocalDate.now()));

        if (karten != null) {
            model.addAttribute("zeigen", karten.get().getAntwort());
            model.addAttribute("active", "zeigen");
            if(karten.get().getLerncount()>0){
                model.addAttribute("erinnerung",7);
                model.addAttribute("act", "erinnerung");
            }else {
                model.addAttribute("erinnerung",2);
                model.addAttribute("act", "erinnerung");
            }


        }else {
            model.addAttribute("active", "z");
        }

        return "karte";
    }

    @GetMapping("antwort/{id}")
    public String antwort(@PathVariable Long  id, Model model){
        karten = karteRepository.findById(id);
        return "redirect:/karte";
    }
    @GetMapping("korrekt")
    public String korrekt(@Valid Karte karte, Model model){
        if(karten.get().getLerncount() == 0){
            karten.get().setLerncount(2);
            karten.get().setDate(LocalDate.now().plusDays(2));
            karten.get().setStatus(Status.KORREKT);
            karteRepository.save(karten.get());
        } else if (karten.get().getLerncount() > 0 && karten.get().getLerncount() < 30 ) {
            karten.get().setLerncount(karten.get().getLerncount()+7);
            karten.get().setDate(LocalDate.now().plusDays(7));
            karten.get().setStatus(Status.KORREKT);
            karteRepository.save(karten.get());
        }else {
            karten.get().setStatus(Status.GELERNT);
            karten.get().setDate(null);
            karteRepository.save(karten.get());
        }
        karten = null;
        return "redirect:/karte";
    }
    @GetMapping("falsch")
    public String falsch(@Valid Karte karte, Model model){

        karten.get().setDate(LocalDate.now().plusDays(1));
        karten.get().setStatus(Status.FALSCH);
        karten.get().setLerncount(2);
        karteRepository.save(karten.get());
        karten = null;

        return "redirect:/karte";
    }

    @GetMapping("new")
    public String newkarte(Karte karte,Model model){
        model.addAttribute("title", "Neue Karte");
        model.addAttribute("lerngruppes", lerngrupperepository.findAll());
        return "karte-form";
    }

    @PostMapping(value="save")
    public String savekarte(@Valid Karte karte, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("lerngruppes",lerngrupperepository.findAll());
            return "karte-form";
        }
        karte.setDate(LocalDate.now());
        karte.setStatus(Status.NEU);
        karte.setLerncount(0);
        karteRepository.save(karte);
        return "redirect:/karte";
    }


}
