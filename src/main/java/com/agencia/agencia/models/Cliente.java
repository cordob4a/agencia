package com.agencia.agencia.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Column(name = "nombre_apellido", nullable = false)
    private String nombreApellido;

    public Cliente() {
    }

    public Cliente(String dni, String nombreApellido) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
}
