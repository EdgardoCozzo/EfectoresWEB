package com.example.Efectores.controladores;

import com.example.Efectores.entidades.Proveedores;
import com.example.Efectores.servicios.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proveedor")
public class ProveedoresController {

    @Autowired
    ProveedorServiceImpl proveedorService;

    @GetMapping("/crear")
    public String crear(ModelMap modelo) {
        return "proveedor_crear.html";
    }

    @PostMapping("/creado")
    public String registro(
            @RequestParam String nombre,
            @RequestParam String domicilio,
            @RequestParam String telefono1,
            @RequestParam String telefono2,
            @RequestParam String cuit,
            @RequestParam String email,
            @RequestParam String nombreDepartamento,
            @RequestParam String nombreProvincia,
            @RequestParam String nombrePais,
            ModelMap modelo) {

        try {
            proveedorService.saveProveedor(nombre, domicilio, telefono1, telefono2, cuit, email, nombreDepartamento, nombreProvincia, nombrePais);

            modelo.put("exito", "El proveedor fue cargado correctamente!");
            modelo.addAttribute("proveedor", proveedorService.getAllProveedores());

            return "proveedor_listar.html";

        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            return "proveedor_crear.html";
        }
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelo) {
        List<Proveedores> proveedor = proveedorService.getAllProveedores();
        if (!proveedor.isEmpty()) {
            modelo.addAttribute("proveedor", proveedor);
        }
        return "proveedor_listar.html";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {
        modelo.put("proveedor", proveedorService.getProveedorById(id));

        return "proveedor_editar.html";
    }


    @PostMapping("/editar/{id}")
    public String modificarProveedor(@PathVariable Long id, Proveedores proveedores, ModelMap modelo) {

        try {
            proveedorService.updateProveedor(id, proveedores);

            modelo.put("exito", "exito");
            return "redirect:../listar";

        } catch (Exception e) {
            modelo.put("proveedor", proveedorService.getProveedorById(id));
            modelo.put("error", e.getMessage());

            return "proveedor_editar.html";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id, ModelMap modelo) {
        proveedorService.deleteProveedor(id);
        return "redirect:/proveedor/listar";
    }
}

