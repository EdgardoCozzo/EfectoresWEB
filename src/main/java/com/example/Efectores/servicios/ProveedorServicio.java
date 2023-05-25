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

@Service
public class ProveedorServicio {
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Transactional
    public Proveedor guardarProveedor(String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia,
                                      LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion) {

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        proveedor.setDomicilio(domicilio);
        proveedor.setTelefono1(telefono1);
        proveedor.setTelefono2(telefono2);
        proveedor.setCuit(cuit);
        proveedor.setEmail(email);
        proveedor.setDepartamento(departamento);
        proveedor.setProvincia(provincia);
//      proveedor.setDepartamento(Departamento.valueOf(departamento));
//      proveedor.setProvincia(Provincia.valueOf(provincia));
        proveedor.setFechaCreacion(fechaCreacion);
        proveedor.setFechaUltModificacion(fechaUltModificacion);
        proveedor.setUsuarioCreacion(usuarioCreacion);
        proveedor.setUsuarioUltModificacion(usuarioUltModificacion);
        return proveedorRepositorio.save(proveedor);
    }


    @Transactional
    public void modificarProveedor(long id, String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia,
                                   LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion) {

        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);
        Proveedor proveedor = null;
        if (respuesta.isPresent()) {
            proveedor = respuesta.get();
            proveedor.setNombre(nombre);
            proveedor.setDomicilio(domicilio);
            proveedor.setCuit(cuit);
            proveedor.setTelefono1(telefono1);
            proveedor.setTelefono2(telefono2);
            proveedor.setEmail(email);
            proveedor.setDepartamento(departamento);
            proveedor.setProvincia(provincia);
            proveedor.setFechaCreacion(fechaCreacion);
            proveedor.setUsuarioCreacion(usuarioCreacion);
            proveedor.setUsuarioUltModificacion(usuarioUltModificacion);
            proveedor.setFechaUltModificacion(fechaUltModificacion);
            proveedorRepositorio.save(proveedor);
        }
    }

    @Transactional
    public List<Proveedor> listarProveedores() {
        return (List<Proveedor>) proveedorRepositorio.findAll();
    }

    @Transactional
    public Proveedor buscarProveedorPorId(Long id) {
        return proveedorRepositorio.findById(id).orElse(null);
    }

    @Transactional
    public void eliminarProveedor(Long id) {
        proveedorRepositorio.deleteById(id);
    }
}
