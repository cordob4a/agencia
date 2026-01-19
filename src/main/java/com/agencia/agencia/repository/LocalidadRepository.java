package com.agencia.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.agencia.agencia.models.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    // Puedes agregar métodos personalizados si los necesitas
}
