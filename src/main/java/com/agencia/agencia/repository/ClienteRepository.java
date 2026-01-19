package com.agencia.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.agencia.agencia.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   
}

