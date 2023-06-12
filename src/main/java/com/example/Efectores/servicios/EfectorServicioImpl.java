package com.example.Efectores.servicios;
import com.example.Efectores.entidades.Efector;
import com.example.Efectores.repositorios.EfectorRepositorio;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class EfectorServicioImpl implements EfectorServicio {
    private final EfectorRepositorio efectorRepositorio;
    public EfectorServicioImpl(EfectorRepositorio efectorRepositorio) {
        this.efectorRepositorio = efectorRepositorio;
    }
    @Override
    public Efector guardarEfector(String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia, LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion) {
        Efector efector = new Efector();
        efector.setNombre(nombre);
        efector.setDomicilio(domicilio);
        efector.setTelefono1(telefono1);
        efector.setTelefono2(telefono2);
        efector.setCuit(cuit);
        efector.setEmail(email);
        efector.setNombreProvincia(provincia);
        efector.setNombreDepartamento(departamento);
        efector.setFechaCreacion(fechaCreacion);
        efector.setFechaUltModificacion(fechaUltModificacion);
        efector.setUsuarioCreacion(usuarioCreacion);
        efector.setUsuarioUltModificacion(usuarioUltModificacion);

        return efectorRepositorio.save(efector);
    }
    @Override
    public Efector modificarEfector(Long id, String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String departamento, String provincia, LocalDate fechaCreacion, String usuarioCreacion, LocalDate fechaUltModificacion, String usuarioUltModificacion) {
        Optional<Efector> respuesta = efectorRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Efector efector = respuesta.get();
            efector.setNombre(nombre);
            efector.setDomicilio(domicilio);
            efector.setCuit(cuit);
            efector.setTelefono1(telefono1);
            efector.setTelefono2(telefono2);
            efector.setEmail(email);
            efector.setNombreDepartamento(departamento);
            efector.setNombreProvincia(provincia);
            efector.setFechaCreacion(fechaCreacion);
            efector.setUsuarioCreacion(usuarioCreacion);
            efector.setUsuarioUltModificacion(usuarioUltModificacion);
            efector.setFechaUltModificacion(fechaUltModificacion);
            efectorRepositorio.save(efector);
        }

        return null;
    }
    @Override
    public List<Efector> listarEfectores() {
        return efectorRepositorio.findByEliminadoFalse();
    }
    @Override
    public Efector buscarEfectorPorId(Long id) {
        return efectorRepositorio.findByIdAndEliminadoFalse(id).orElse(null);
    }
    @Override
    public void eliminarEfector(Long id) {
        Efector efector = efectorRepositorio.findById(id).orElse(null);
        if (efector != null) {
            efector.setEliminado(true);
            efectorRepositorio.save(efector);
        }
    }
}
