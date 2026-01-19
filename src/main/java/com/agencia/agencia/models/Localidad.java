package com.agencia.agencia.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "localidad")
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "localidad", nullable = false)
    private String localidad;

    @Column(name = "importe", nullable = false, precision = 10, scale = 2)
    private BigDecimal importe;  // Cambiado de Integer a BigDecimal

    public Localidad() {
    }

    public Localidad(String localidad, BigDecimal importe) {
        this.localidad = localidad;
        this.importe = importe;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    // Método toString() opcional para logging
    @Override
    public String toString() {
        return "Localidad{" +
               "id=" + id +
               ", localidad='" + localidad + '\'' +
               ", importe=" + importe +
               '}';
    }
}
