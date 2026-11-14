package br.edu.umc.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Abrir http://localhost:8080 leva direto para a listagem
    @GetMapping("/")
    public String home() {
        return "redirect:/livros";
    }
}
