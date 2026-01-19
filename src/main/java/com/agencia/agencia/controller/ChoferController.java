package com.agencia.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.agencia.agencia.models.Chofer;
import com.agencia.agencia.service.ChoferService;

@Controller
@RequestMapping("/choferes")
public class ChoferController {

    @Autowired
    private ChoferService service;

    @GetMapping("")
    public String listarChoferes(Model modelo) {
        modelo.addAttribute("choferes", service.listarChoferes());
        return "choferes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeChoferes(Model modelo) {
        Chofer chofer = new Chofer();
        modelo.addAttribute("chofer", chofer);
        return "crear_chofer";
    }

    @PostMapping("")
    public String guardarChofer(@ModelAttribute("chofer") Chofer chofer) {
        service.guardarChofer(chofer);
        return "redirect:/choferes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFomularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("chofer", service.obtenerChoferId(id));
        return "editar_chofer";
    }

    @PostMapping("/{id}")
    public String actualizarChofer(@PathVariable Long id, @ModelAttribute("chofer") Chofer chofer) {
        Chofer choferExistente = service.obtenerChoferId(id);
        choferExistente.setNombreApellido(chofer.getNombreApellido());
        choferExistente.setAuto(chofer.getAuto());
        choferExistente.setDni(chofer.getDni());
        choferExistente.setFechaFinLic(chofer.getFechaFinLic());
        service.actualizaChofer(choferExistente);
        return "redirect:/choferes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarChofer(@PathVariable Long id) {
        service.eliminarChofer(id);
        return "redirect:/choferes";
    }
}