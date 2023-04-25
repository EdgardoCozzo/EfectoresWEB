package com.example.Efectores.repositorios;

import com.example.Efectores.entidades.Proveedores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedores,Long> {
}
