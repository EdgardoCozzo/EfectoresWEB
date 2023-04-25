package com.example.Efectores.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="domicilio")
    private String domicilio;
    @Column(name="nombrePais")
    private String nombrePais;
    @Column(name="nombreProvincia")
    private String nombreProvincia;
    @Column(name="nombreDepartamento")
    private String nombreDepartamento;
    @Column(name="cuit")
    private String cuit;
    @Column(name="telefono1")
    private String telefono1;
    @Column(name="telefono2")
    private String telefono2;
    @Column(name="email")
    private String email;


}
