package com.example.Efectores.entidades;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    /*@ManyToOne
    @JoinColumn(name="idTipo")
    private Tipo tipo;*/

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    @Column(name = "UsuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "fechaUltimaModificacion")
    private LocalDate fechaUltModificacion;

    @Column(name = "UsuarioUltimaModificacion")
    private String usuarioUltModificacion;

    @Column(name = "eliminado")
    private boolean eliminado = false;


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
