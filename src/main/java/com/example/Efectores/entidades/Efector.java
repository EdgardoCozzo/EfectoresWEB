package com.example.Efectores.entidades;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table
@Entity
public class Efector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="domicilio")
    private String domicilio;

    @Column(name="provincia")
    private String nombreProvincia;
    @Column(name="departamento")
    private String nombreDepartamento;
    @Column(name="pais")
    private String nombrePais;

    @Column(name="cuit")
    private String cuit;
    @Column(name="telefono1")
    private String telefono1;
    @Column(name="telefono2")
    private String telefono2;
    @Column(name="email")
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
    private boolean eliminado = false;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaUltModificacion = LocalDate.now();
    }
}