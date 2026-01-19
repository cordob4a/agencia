package com.agencia.agencia.service;

import com.agencia.agencia.models.Viaje;

import java.util.List;
import java.util.Optional;

public interface ViajeService {
    
    List<Viaje> listarTodos();

    void guardar(Viaje viaje);

    Optional<Viaje> obtenerPorId(Long id);

    void eliminarViaje(Long id);
}
