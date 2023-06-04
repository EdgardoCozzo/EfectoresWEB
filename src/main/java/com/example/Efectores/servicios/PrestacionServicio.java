package com.example.Efectores.servicios;
import com.example.Efectores.entidades.Prestacion;
import java.util.List;
import java.time.LocalDate;

public interface PrestacionServicio {

    Prestacion guardarPrestacion(String nombre,long idProveedor , LocalDate fechaCreacion,
                                 String usuarioCreacion, LocalDate fechaUltModificacion,
                                 String usuarioUltModificacion);

    Prestacion modificarPrestacion(long id, String nombre,long idProveedor , LocalDate fechaUltModificacion,
                                   String usuarioUltModificacion);

    List<Prestacion> listarPrestaciones();

    Prestacion buscarPrestacionPorId(Long id);

    void eliminarPrestacion(Long id);

}
