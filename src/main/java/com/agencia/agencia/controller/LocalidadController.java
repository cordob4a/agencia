package com.agencia.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.agencia.agencia.models.Localidad;
import com.agencia.agencia.service.LocalidadService;
import java.math.BigDecimal;

@Controller
@RequestMapping("/localidades")
public class LocalidadController {

    @Autowired
    private LocalidadService localidadService;

    @GetMapping("")
    public String listarLocalidades(Model modelo) {
        modelo.addAttribute("localidades", localidadService.listarLocalidades());
        return "localidades";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoLocalidad(Model modelo) {
        modelo.addAttribute("localidad", new Localidad());
        return "crear_localidad";
    }

    @PostMapping("")
    public String guardarLocalidad(
            @RequestParam("localidad") String nombreLocalidad,
            @RequestParam("importe") BigDecimal importe) {

        Localidad nuevaLocalidad = new Localidad(nombreLocalidad, importe);
        localidadService.guardarLocalidad(nuevaLocalidad);
        return "redirect:/localidades";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarLocalidad(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("localidad", localidadService.obtenerLocalidadPorId(id));
        return "editar_localidad";
    }

    // Cambié el mapping para que reciba el id en la URL (PathVariable)
    @PostMapping("/{id}")
    public String actualizarLocalidad(
            @PathVariable("id") Long id,
            @RequestParam("localidad") String nombreLocalidad,
            @RequestParam("importe") BigDecimal importe) {

        Localidad localidad = localidadService.obtenerLocalidadPorId(id);
        localidad.setLocalidad(nombreLocalidad);
        localidad.setImporte(importe);
        localidadService.guardarLocalidad(localidad);
        return "redirect:/localidades";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLocalidad(@PathVariable("id") Long id) {
        localidadService.eliminarLocalidad(id);
        return "redirect:/localidades";
    }
}

