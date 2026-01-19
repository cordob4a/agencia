package com.agencia.agencia.service;

import com.agencia.agencia.models.Viaje;
import com.agencia.agencia.repository.ViajeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeServiceImpl implements ViajeService {

    private final ViajeRepository viajeRepository;

    // Constructor sin @Autowired (innecesario si hay uno solo)
    public ViajeServiceImpl(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Viaje> listarTodos() {
        return viajeRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Viaje viaje) {
        validarViaje(viaje);
        normalizarDatos(viaje);
        viajeRepository.save(viaje);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Viaje> obtenerPorId(Long id) {
        return viajeRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminarViaje(Long id) {
        if (!viajeRepository.existsById(id)) {
            throw new IllegalArgumentException("Viaje con ID " + id + " no existe");
        }
        viajeRepository.deleteById(id);
    }

    private void validarViaje(Viaje viaje) {
        if (viaje.getChofer() == null || viaje.getChofer().getId() == null) {
            throw new IllegalArgumentException("Chofer es requerido");
        }
        if (viaje.getLocalidad() == null || viaje.getLocalidad().getId() == null) {
            throw new IllegalArgumentException("Localidad es requerida");
        }
        if (viaje.getFechaHora() == null) {
            throw new IllegalArgumentException("Fecha/Hora es requerida");
        }
    }

    private void normalizarDatos(Viaje viaje) {
        if (viaje.getChofer() != null && viaje.getChofer().getNombreApellido() != null) {
            viaje.getChofer().setNombreApellido(
                viaje.getChofer().getNombreApellido().trim().toUpperCase());
        }
        if (viaje.getLocalidad() != null && viaje.getLocalidad().getLocalidad() != null) {
            viaje.getLocalidad().setLocalidad(
                viaje.getLocalidad().getLocalidad().trim().toUpperCase());
        }
    }
}
