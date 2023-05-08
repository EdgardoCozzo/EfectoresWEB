package com.example.Efectores.servicios;


import com.example.Efectores.entidades.Producto;

import java.time.LocalDate;
import java.util.List;

public interface ProductoService {

    List<Producto> getAllProducto();

    Producto getProductoById(Long id);

    Producto saveProducto(String nombre, LocalDate fechaCreacion, String usuarioCreacion,
                          LocalDate fechaUltModificacion, String usuarioUltModificacion);

    Producto updateProducto(Long id, Producto producto);

    void deleteProducto(Long Id);


}
