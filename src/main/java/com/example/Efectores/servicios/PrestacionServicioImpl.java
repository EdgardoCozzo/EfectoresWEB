package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Prestacion;
import com.example.Efectores.entidades.Proveedor;
import com.example.Efectores.repositorios.PrestacionRepositorio;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.example.Efectores.repositorios.ProveedorRepositorio;
import org.springframework.stereotype.Service;

@Service
public class PrestacionServicioImpl implements PrestacionServicio{
    private final PrestacionRepositorio prestacionRepositorio;
    private ProveedorRepositorio proveedorRepositorio;

    public PrestacionServicioImpl(PrestacionRepositorio prestacionRepositorio) {
        this.prestacionRepositorio = prestacionRepositorio;
    }

    @Override
    public Prestacion guardarPrestacion(String nombre, long idProveedor ,LocalDate fechaCreacion, String usuarioCreacion,
                                        LocalDate fechaUltModificacion, String usuarioUltModificacion) {

        Proveedor proveedor=proveedorRepositorio.findById(idProveedor).get();

        Prestacion prestacion = new Prestacion();

        prestacion.setNombre(nombre);
        prestacion.setProveedor(proveedor);
        prestacion.setFechaCreacion(fechaCreacion);
        prestacion.setFechaUltModificacion(fechaUltModificacion);
        prestacion.setUsuarioCreacion(usuarioCreacion);
        prestacion.setUsuarioUltModificacion(usuarioUltModificacion);
        return prestacionRepositorio.save(prestacion);
    }

    @Override
    public Prestacion modificarPrestacion(long id, String nombre,long idProveedor , LocalDate fechaUltModificacion,
                                          String usuarioUltModificacion) {
        Optional<Prestacion>respuesta= prestacionRepositorio.findByIdAndEliminadoFalse(id);

        if (respuesta.isPresent()) {

            Prestacion prestacion = respuesta.get();
            prestacion.setNombre(nombre);
            prestacion.setProveedor(proveedorRepositorio.findById(idProveedor).get());
            prestacion.setUsuarioUltModificacion(usuarioUltModificacion);
            prestacion.setFechaUltModificacion(fechaUltModificacion);
            prestacionRepositorio.save(prestacion);
        }
        return null;
    }

    @Override
    public List<Prestacion> listarPrestaciones() {

        return prestacionRepositorio.findByEliminadoFalse();
    }

    @Override
    public Prestacion buscarPrestacionPorId(Long id) {
        return prestacionRepositorio.findByIdAndEliminadoFalse(id).orElse(null);
    }

    @Override
    public void eliminarPrestacion(Long id) {
        Prestacion prestacion = prestacionRepositorio.findById(id).orElse(null);
        if (prestacion != null) {
            prestacion.setEliminado(true);
            prestacionRepositorio.save(prestacion);
        }
    }

}
