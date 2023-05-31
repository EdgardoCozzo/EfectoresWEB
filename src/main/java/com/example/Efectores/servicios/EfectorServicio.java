package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Efector;

import java.time.LocalDate;
import java.util.List;

public interface EfectorServicio {

    Efector guardarEfector(String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia,
                               LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion);

    Efector modificarEfector(Long id, String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia,
                                 LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion);

    List<Efector> listarEfectores();

    Efector buscarEfectorPorId(Long id);


    void eliminarEfector(Long id);

}
