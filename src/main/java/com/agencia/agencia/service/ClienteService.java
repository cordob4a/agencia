package com.agencia.agencia.service;

import java.util.List;



import com.agencia.agencia.models.Cliente;

public interface ClienteService {

    List<Cliente> listarClientes();

    Cliente guardarCliente(Cliente cliente);

    Cliente obtenerClientePorId(Long id);  // CORREGIDO: devuelve Cliente, no Chofer

    Cliente actualizarCliente(Cliente cliente);

    void eliminarCliente(Long id);
}

