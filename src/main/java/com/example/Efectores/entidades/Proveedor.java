package com.example.Efectores.entidades;

import com.example.Efectores.enumeraciones.Departamento;
import com.example.Efectores.enumeraciones.Provincia;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Domicilio")
    private String domicilio;

    //    @Column(name="Provincia")
//    @Enumerated(EnumType.STRING)
//    private Provincia provincia;
//
//    @Column(name="Departamento")
//    @Enumerated(EnumType.STRING)
//    private Departamento departamento;
    @Column(name = "provincia")
    private String provincia;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "CUIT")
    private String cuit;

    @Column(name = "telefono1")
    private String telefono1;

    @Column(name = "telefono2")
    private String telefono2;

    @Column(name = "email")
    private String email;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    @Column(name = "UsuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "fechaUltimaModificacion")
    private LocalDate fechaUltModificacion;

    @Column(name = "UsuarioUltimaModificacion")
    private String usuarioUltModificacion;

    @Column(name = "eliminado")
    private Boolean eliminado = false;


    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDate.now(); // Establecer la fecha de creación en la fecha actual
        // usuarioCreacion = authentication.getName(); // Establecer el usuario de creación en el usuario actual
    }

    @PreUpdate
    public void preUpdate() {
        fechaUltModificacion = LocalDate.now(); // Establecer la fecha de última modificación en la fecha actual
        // usuarioUltModificacion = authentication.getName(); // Establecer el usuario de última modificación en el usuario actual
    }

}
