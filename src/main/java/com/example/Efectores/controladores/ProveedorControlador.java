package com.example.Efectores.controladores;

import com.example.Efectores.entidades.Proveedor;
import com.example.Efectores.servicios.ProveedorServicioImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/proveedor")
public class ProveedorControlador {

    private final ProveedorServicioImpl proveedorServicio;

    public ProveedorControlador(ProveedorServicioImpl proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    @GetMapping("/crear")
    public String crear(ModelMap modelo) {

//        modelo.addAttribute("provincia", Provincia.values());
//        modelo.addAttribute("departamento", Departamento.values());

        return "proveedor_crear.html";
    }

    @PostMapping("/creado")
    public String registro(
            @RequestParam String nombre,
            @RequestParam String domicilio,
            @RequestParam String telefono1,
            String telefono2,
            @RequestParam String cuit,
            @RequestParam String email,
            @RequestParam String departamento,
            @RequestParam String provincia,
            LocalDate fechaCreacion,
            String usuarioCreacion,
            LocalDate fechaUltModificacion,
            String usuarioUltModificacion,
            ModelMap modelo) {

        try {
            proveedorServicio.guardarProveedor(nombre, domicilio, telefono1, telefono2, cuit, email, departamento, provincia,fechaCreacion,usuarioCreacion,fechaUltModificacion,usuarioUltModificacion);

            modelo.put("exito", "El proveedor fue cargado correctamente!");
            modelo.addAttribute("proveedor", proveedorServicio.listarProveedores());

            return "proveedor_listar.html";

        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            return "proveedor_crear.html";
        }
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelo) {
        List<Proveedor> proveedores = proveedorServicio.listarProveedores();
        modelo.addAttribute("proveedor", proveedores);

        return"proveedor_listar.html";
}

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {
        modelo.put("proveedor", proveedorServicio.buscarProveedorPorId(id));

//        modelo.addAttribute("provincias", Provincia.values());
//        modelo.addAttribute("departamentos", Departamento.values());

        return "proveedor_editar.html";
    }


    @PostMapping("/editar/{id}")
    public String modificarProveedor(@PathVariable Long id,
                                     String nombre,
                                     String domicilio,
                                     String telefono1,
                                     String telefono2,
                                     String cuit,
                                     String email,
                                     String departamento,
                                     String provincia,
                                     LocalDate fechaCreacion,
                                     String usuarioCreacion,
                                     LocalDate fechaUltModificacion,
                                     String usuarioUltModificacion, ModelMap modelo) {

        try {
            proveedorServicio.modificarProveedor(id,nombre,domicilio,telefono1, telefono2, cuit, email,departamento, provincia,
                    fechaCreacion, usuarioCreacion, fechaUltModificacion,usuarioUltModificacion );

            modelo.put("exito", "exito");
            return "redirect:../listar";

        } catch (Exception e) {
            modelo.put("proveedor", proveedorServicio.buscarProveedorPorId(id));
            modelo.put("error", e.getMessage());

            return "proveedor_editar.html";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id, ModelMap modelo) {
        proveedorServicio.eliminarProveedor(id);
        return "redirect:/proveedor/listar";
    }
}

