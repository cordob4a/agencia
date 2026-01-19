package com.agencia.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.agencia.models.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {

}
