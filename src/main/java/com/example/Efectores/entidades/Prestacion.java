package com.example.Efectores.entidades;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table
public class Prestacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="idProveedoor")
    private Proveedor proveedor;

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
