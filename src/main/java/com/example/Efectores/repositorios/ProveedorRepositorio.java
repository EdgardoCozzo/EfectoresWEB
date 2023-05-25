package com.example.Efectores.repositorios;

import com.example.Efectores.entidades.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends CrudRepository<Proveedor,Long> {
}
