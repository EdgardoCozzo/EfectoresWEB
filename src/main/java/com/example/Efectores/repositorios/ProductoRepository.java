package com.example.Efectores.repositorios;

import com.example.Efectores.entidades.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long > {

    List<Producto> findByEliminadoFalse();
    Optional<Producto> findByIdAndEliminadoFalse(Long id);
}
