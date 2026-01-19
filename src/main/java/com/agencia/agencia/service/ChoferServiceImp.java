package com.agencia.agencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.agencia.models.Chofer;
import com.agencia.agencia.repository.ChoferRepository;

@Service
public class ChoferServiceImp implements ChoferService {

    @Autowired
    ChoferRepository repositorio;

    @Override
    public List<Chofer> listarChoferes() {
        return repositorio.findAll();
    }

    @Override
    public Chofer guardarChofer(Chofer chofer) {
        return repositorio.save(chofer);
    }

    @Override
    public Chofer obtenerChoferId(Long id) {
        return repositorio.findById(id).orElse(null); // ✅ corregido
    }

    @Override
    public Chofer actualizaChofer(Chofer chofer) {
        return repositorio.save(chofer);
    }

    @Override
    public void eliminarChofer(Long id) {
        repositorio.deleteById(id);
    }
}
