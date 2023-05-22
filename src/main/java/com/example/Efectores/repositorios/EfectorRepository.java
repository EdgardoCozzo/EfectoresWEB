package com.example.Efectores.repositorios;

import com.example.Efectores.entidades.Efector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EfectorRepository extends CrudRepository<Efector,Long> {

    List<Efector> findByEliminadoFalse();
    Optional<Efector> findByIdAndEliminadoFalse(Long id);
}
