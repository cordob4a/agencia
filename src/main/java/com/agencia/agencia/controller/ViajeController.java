package com.agencia.agencia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.agencia.agencia.models.Chofer;
import com.agencia.agencia.models.Cliente;
import com.agencia.agencia.models.Localidad;
import com.agencia.agencia.models.Viaje;
import com.agencia.agencia.service.ChoferService;
import com.agencia.agencia.service.ClienteService;
import com.agencia.agencia.service.LocalidadService;
import com.agencia.agencia.service.ViajeService;

import org.hibernate.Hibernate;

@Controller
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @Autowired
    private ChoferService choferService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private LocalidadService localidadService;

    // Listar viajes
    @GetMapping("")
    public String listarViajes(Model modelo) {
        List<Viaje> viajes = viajeService.listarTodos();

        viajes.forEach(viaje -> {
            Hibernate.initialize(viaje.getCliente());
            Hibernate.initialize(viaje.getChofer());
            Hibernate.initialize(viaje.getLocalidad());
        });

        modelo.addAttribute("viajes", viajes);
        return "viajes";
    }

    // Mostrar formulario de nuevo viaje
    @GetMapping("/nuevo")
    public String mostrarFormularioDeViaje(Model modelo) {
        Viaje viaje = new Viaje();
        List<Chofer> choferes = choferService.listarChoferes();
        List<Cliente> clientes = clienteService.listarClientes();
        List<Localidad> localidades = localidadService.listarLocalidades();

        modelo.addAttribute("viaje", viaje);
        modelo.addAttribute("choferes", choferes);
        modelo.addAttribute("clientes", clientes);
        modelo.addAttribute("localidades", localidades);

        return "crear_viaje";
    }

    // Guardar nuevo viaje (sin nueva localidad)
    @PostMapping("")
    public String guardarViaje(@ModelAttribute("viaje") Viaje viaje) {
        viajeService.guardar(viaje);
        return "redirect:/viajes";
    }

    // Mostrar formulario para editar viaje
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        viajeService.obtenerPorId(id).ifPresent(viaje -> {
            Hibernate.initialize(viaje.getCliente());
            Hibernate.initialize(viaje.getChofer());
            Hibernate.initialize(viaje.getLocalidad());

            List<Chofer> choferes = choferService.listarChoferes();
            List<Cliente> clientes = clienteService.listarClientes();
            List<Localidad> localidades = localidadService.listarLocalidades();

            modelo.addAttribute("viaje", viaje);
            modelo.addAttribute("choferes", choferes);
            modelo.addAttribute("clientes", clientes);
            modelo.addAttribute("localidades", localidades);
        });
        return "editar_viaje";
    }

    // Actualizar viaje existente (sin nueva localidad)
    @PostMapping("/{id}")
    public String actualizarViaje(@PathVariable Long id,
                                  @ModelAttribute("viaje") Viaje viajeActualizado) {
        viajeService.obtenerPorId(id).ifPresent(viajeExistente -> {
            viajeExistente.setChofer(viajeActualizado.getChofer());
            viajeExistente.setCliente(viajeActualizado.getCliente());
            viajeExistente.setFechaHora(viajeActualizado.getFechaHora());
            viajeExistente.setLocalidad(viajeActualizado.getLocalidad());

            viajeService.guardar(viajeExistente);
        });

        return "redirect:/viajes";
    }

    // Eliminar viaje
    @PostMapping("/{id}/eliminar")
    public String eliminarViaje(@PathVariable Long id) {
        viajeService.eliminarViaje(id);
        return "redirect:/viajes";
    }
}
