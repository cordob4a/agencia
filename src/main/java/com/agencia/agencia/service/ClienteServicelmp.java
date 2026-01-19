
package com.agencia.agencia.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.agencia.models.Cliente;
import com.agencia.agencia.repository.ClienteRepository;

@Service
public class ClienteServicelmp implements ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<Cliente> listarClientes() {
        return repositorio.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return repositorio.findById(id).orElse(null);// <-- Devuelve Optional<Cliente>
    }
    /*public Chofer obtenerChoferId(Long id) {
        return repositorio.findById(id).orElse(null); */

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        repositorio.deleteById(id);
    }
}
