package com.agencia.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.agencia.models.Chofer;

@Repository
public interface ChoferRepository extends JpaRepository<Chofer,Long> {

}
