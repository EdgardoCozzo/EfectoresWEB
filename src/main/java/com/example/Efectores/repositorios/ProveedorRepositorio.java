package com.example.Efectores.repositorios;

import com.example.Efectores.entidades.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepositorio extends CrudRepository<Proveedor,Long> {

    List<Proveedor>findByEliminadoFalse();
    Optional<Proveedor>findByIdAndEliminadoFalse(Long id);

}
