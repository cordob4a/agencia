package com.agencia.agencia.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chofer")
public class Chofer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre_apellido")
    private String nombreApellido;
    private String auto;
    private String dni;   
    @Column(name="fecha_fin_lic")
    private LocalDate fechaFinLic;

    public Chofer() {
    }

    public Chofer(String auto, String dni, LocalDate fechaFinLic, String nombreApellido) {
        this.auto = auto;
        this.dni = dni;
        this.fechaFinLic = fechaFinLic;
        this.nombreApellido = nombreApellido;
    }


    public Long getId() {
        return id;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getAuto() {
        return auto;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaFinLic() {
        return fechaFinLic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaFinLic(LocalDate fechaFinLic) {
        this.fechaFinLic = fechaFinLic;
    }

}