package com.example.Efectores.repositorios;

import com.example.Efectores.entidades.Prestacion;
import com.example.Efectores.entidades.Proveedor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PrestacionRepositorio extends CrudRepository<Prestacion,Long> {

    List<Prestacion> findByEliminadoFalse();
    Optional<Prestacion> findByIdAndEliminadoFalse(Long id);

}
