package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Proveedor;
import com.example.Efectores.repositorios.ProveedorRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

    private final ProveedorRepositorio proveedorRepositorio;

    public ProveedorServicioImpl(ProveedorRepositorio proveedorRepositorio) {
        this.proveedorRepositorio = proveedorRepositorio;
    }

    @Override
    public Proveedor guardarProveedor(String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia, LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        proveedor.setDomicilio(domicilio);
        proveedor.setTelefono1(telefono1);
        proveedor.setTelefono2(telefono2);
        proveedor.setCuit(cuit);
        proveedor.setEmail(email);
        proveedor.setProvincia(provincia);
        proveedor.setDepartamento(departamento);
//        proveedor.setDepartamento(Departamento.valueOf(departamento));
//      proveedor.setProvincia(Provincia.valueOf(provincia));
        proveedor.setFechaCreacion(fechaCreacion);
        proveedor.setFechaUltModificacion(fechaUltModificacion);
        proveedor.setUsuarioCreacion(usuarioCreacion);
        proveedor.setUsuarioUltModificacion(usuarioUltModificacion);
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public Proveedor modificarProveedor(long id, String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email,
                                        String departamento, String provincia, LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion,
                                        String usuarioUltModificacion) {
        Optional<Proveedor> respuesta = proveedorRepositorio.findById(id);


        if (respuesta.isPresent()) {

            Proveedor proveedor = respuesta.get();
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
        return null;
    }

    @Override
    public List<Proveedor> listarProveedores() {

        return proveedorRepositorio.findByEliminadoFalse();
    }

    @Override
    public Proveedor buscarProveedorPorId(Long id) {
        return proveedorRepositorio.findByIdAndEliminadoFalse(id).orElse(null);
    }

    @Override
    public void eliminarProveedor(Long id) {
        Proveedor proveedor = proveedorRepositorio.findById(id).orElse(null);
        if (proveedor != null) {
            proveedor.setEliminado(true);
            proveedorRepositorio.save(proveedor);
        }
    }


}
