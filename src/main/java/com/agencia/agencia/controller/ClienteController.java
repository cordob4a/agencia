package com.agencia.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.agencia.agencia.models.Cliente;
import com.agencia.agencia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", clienteService.listarClientes());
        return "clientes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cliente", clienteService.obtenerClientePorId(id));
        return "editar_cliente";
    }

    @PostMapping("/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        Cliente clienteExistente = clienteService.obtenerClientePorId(id);
        clienteExistente.setNombreApellido(cliente.getNombreApellido());
        clienteExistente.setDni(cliente.getDni());
        clienteService.actualizarCliente(clienteExistente);
        return "redirect:/clientes";
    }

    // ✅ Método agregado para eliminar con GET (usado por el <a> en el HTML)
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
