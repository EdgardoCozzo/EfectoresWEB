package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Producto;
import com.example.Efectores.repositorios.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    // private final TipoRepository tipoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarProducto() {
        return productoRepository.findByEliminadoFalse();

    }

    @Override
    public Producto buscarProductoPorId(Long id) {

        return productoRepository.findByIdAndEliminadoFalse(id).orElse(null);
    }

    @Override
    public Producto guardarProducto(String nombre, LocalDate fechaCreacion, String usuarioCreacion,
                                 LocalDate fechaUltModificacion, String usuarioUltModificacion) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setFechaCreacion(fechaCreacion);
        producto.setFechaUltModificacion(fechaUltModificacion);
        producto.setUsuarioCreacion(usuarioCreacion);
        producto.setUsuarioUltModificacion(usuarioCreacion);
        return productoRepository.save(producto);
    }


    @Override
    public Producto modificarProducto(Long id, Producto producto) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);


        if (optionalProducto.isPresent()) {
            Producto productoActual = optionalProducto.get();

            productoActual.setNombre(producto.getNombre());
            productoActual.setUsuarioUltModificacion(producto.getUsuarioUltModificacion());
            productoActual.setFechaUltModificacion(producto.getFechaUltModificacion());

            return productoRepository.save(productoActual);

        }
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setEliminado(true);
            productoRepository.save(producto);
        }
    }
}
