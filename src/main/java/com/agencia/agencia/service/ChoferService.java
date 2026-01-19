package com.agencia.agencia.service;

import java.util.List;

import com.agencia.agencia.models.Chofer;

public interface ChoferService {

    public List<Chofer> listarChoferes();

    public Chofer guardarChofer(Chofer chofer);

    public Chofer obtenerChoferId(Long id);

    public Chofer actualizaChofer(Chofer chofer);

    public void eliminarChofer(Long id);


}
