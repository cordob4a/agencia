package com.agencia.agencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.agencia.models.Localidad;
import com.agencia.agencia.repository.LocalidadRepository;

@Service
public class LocalidadServicelmp implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    @Override
    public List<Localidad> listarLocalidades() {
        return localidadRepository.findAll();
    }

    @Override
    public Localidad guardarLocalidad(Localidad localidad) {
        return localidadRepository.save(localidad);
    }

    @Override
    public Localidad obtenerLocalidadPorId(Long id) {
        return localidadRepository.findById(id).orElse(null);
    }

    @Override
    public Localidad actualizarLocalidad(Localidad localidad) {
        return localidadRepository.save(localidad);
    }

    @Override
    public void eliminarLocalidad(Long id) {
        localidadRepository.deleteById(id);
    }
}
