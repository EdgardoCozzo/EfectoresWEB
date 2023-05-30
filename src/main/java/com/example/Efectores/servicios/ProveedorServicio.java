package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Proveedor;
import com.example.Efectores.enumeraciones.Departamento;
import com.example.Efectores.enumeraciones.Provincia;
import com.example.Efectores.repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface ProveedorServicio {


    Proveedor guardarProveedor(String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia,
                               LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion);

    Proveedor modificarProveedor(long id, String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia,
                                 LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion);


    List<Proveedor> listarProveedores();

    Proveedor buscarProveedorPorId(Long id);


    void eliminarProveedor(Long id);
}
