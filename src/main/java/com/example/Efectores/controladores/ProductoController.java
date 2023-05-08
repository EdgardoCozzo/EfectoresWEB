package com.example.Efectores.controladores;

import com.example.Efectores.entidades.Producto;
import com.example.Efectores.servicios.ProductoServiceImpl;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



import java.time.LocalDate;
import java.util.List;

@Controller
@Data
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoServiceImpl productoService;
    //private final tipoServiceImpl tipoService;


    @GetMapping("/crear")
    public String crear(ModelMap modelo) {

        List<Producto> producto = productoService.getAllProducto();
        //List<Tipo> tipo=tipoService.getAllTipo();

        modelo.addAttribute("producto", producto);
        //modelo.addAttribute("tipo", tipos);


        return "producto_crear.html";
    }

    @PostMapping("/creado")
    @Transactional
    public String registro(@RequestParam String nombre, LocalDate fechaCreacion,
                           String usuarioCreacion, LocalDate fechaUltModificacion,
                           String usuarioUltModificacion, ModelMap modelo) {
        try {
            productoService.saveProducto(nombre, fechaCreacion, usuarioCreacion, fechaUltModificacion, usuarioUltModificacion);
            modelo.put("exito", "El producto se cargo con exito");
            modelo.addAttribute("producto", productoService.getAllProducto());

            return "producto_listar.html";
        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());

            return "producto_crear.html";
        }


    }

    @GetMapping("/listar")
    public String listar(ModelMap modelo) {
        List<Producto> producto = productoService.getAllProducto();

        if (!producto.isEmpty()) {
            modelo.addAttribute("producto", producto);
        }
        return "producto_listar.html";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {

        modelo.put("producto", productoService.getProductoById(id));

        return "producto_editar.html";
    }

    @PostMapping("/editar/{id}")
    @Transactional
    public String editarProducto(@PathVariable Long id, Producto producto, ModelMap modelo) {
        try {
            productoService.updateProducto(id, producto);

            modelo.put("exito", "exito");
            return "redirect:../listar";
        } catch (Exception ex) {
            modelo.put("producto", productoService.getProductoById(id));
            modelo.put("error", ex.getMessage());

            return "producto_editar.html";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, ModelMap modelo) {
        productoService.deleteProducto(id);
        return "redirect:/producto/listar";
    }


}
