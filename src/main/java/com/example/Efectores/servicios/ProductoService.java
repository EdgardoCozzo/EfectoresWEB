package com.example.Efectores.servicios;


import com.example.Efectores.entidades.Producto;

import java.time.LocalDate;
import java.util.List;

public interface ProductoService {

    List<Producto> listarProducto();

    Producto buscarProductoPorId(Long id);

    Producto guardarProducto(String nombre, LocalDate fechaCreacion, String usuarioCreacion,
                          LocalDate fechaUltModificacion, String usuarioUltModificacion);

    Producto modificarProducto(Long id, Producto producto);

    void eliminarProducto(Long Id);


}
