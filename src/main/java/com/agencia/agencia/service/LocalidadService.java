package com.agencia.agencia.service;

import java.util.List;
import com.agencia.agencia.models.Localidad;

public interface LocalidadService {

    List<Localidad> listarLocalidades();

    Localidad guardarLocalidad(Localidad localidad);

    Localidad obtenerLocalidadPorId(Long id); // <- actualizado

    Localidad actualizarLocalidad(Localidad localidad);

    void eliminarLocalidad(Long id);
}

