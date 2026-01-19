package com.agencia.agencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    // Página principal única
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "index"; // Archivo: src/main/resources/templates/index.html
    }
    
    // Redirección para mantener compatibilidad
    @GetMapping("/index")
    public String redirectToHome() {
        return "redirect:/";
    }
}