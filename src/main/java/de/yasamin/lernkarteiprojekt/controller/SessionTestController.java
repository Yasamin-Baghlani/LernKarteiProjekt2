package de.yasamin.lernkarteiprojekt.controller;

import de.yasamin.lernkarteiprojekt.model.User;
import de.yasamin.lernkarteiprojekt.repository.UserRepository;
import de.yasamin.lernkarteiprojekt.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
@CrossOrigin
@Transactional
public class SessionTestController {

    private final UserRepository userRepository;

    private final LoginService loginService;


    @GetMapping("login")
    public String loginForm(Model model) {
        if(loginService.isLoggedIn())
            return "redirect:/karte";

        return "login-form";
    }

    @PostMapping(value="login")
    public String login(String email,String password, Model model) {

        Optional<User> opt = userRepository.findByEmail(email);
        if(opt.isPresent()) {
            User us = opt.get();
            if(us.getPassword().equals(password)) {
                loginService.doLogIn(us);
                return "redirect:/karte";
            }
        }
        model.addAttribute("error", true);
        return "login-form";
    }

}
