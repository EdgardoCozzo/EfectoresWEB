package com.example.Efectores.controladores;

import com.example.Efectores.entidades.Efector;
import com.example.Efectores.servicios.EfectorServicio;
import com.example.Efectores.servicios.EfectorServicioImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/efector")
public class EfectorControlador {

    private final EfectorServicioImpl efectorServicio;


    public EfectorControlador(EfectorServicioImpl efectorServicio) {
        this.efectorServicio = efectorServicio;
    }

    @GetMapping("/crear")
    public String crear(ModelMap modelo) {
        return "efector_crear.html";
    }

    @PostMapping("creado")
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
            efectorServicio.guardarEfector(nombre, domicilio, telefono1, telefono2, cuit, email, departamento, provincia,fechaCreacion,usuarioCreacion,fechaUltModificacion,usuarioUltModificacion);

            modelo.put("exito", "El efector fue cargado correctamente!");
            modelo.addAttribute("proveedor", efectorServicio.listarEfectores());

            return "efector_listar.html";

        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            return "efector_crear.html";
        }
    }
    @GetMapping("/listar")
    public String listar(ModelMap modelo) {
        List<Efector> efectores = efectorServicio.listarEfectores();
        modelo.addAttribute("efector", efectores);

        return"proveedor_listar.html";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {
        modelo.put("efector", efectorServicio.buscarEfectorPorId(id));

//        modelo.addAttribute("provincias", Provincia.values());
//        modelo.addAttribute("departamentos", Departamento.values());

        return "efector_editar.html";
    }

    @PostMapping("/editar/{id}")
    public String modificarEfector(@PathVariable Long id,
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
            efectorServicio.modificarEfector(id,nombre,domicilio,telefono1, telefono2, cuit, email,departamento, provincia,
                    fechaCreacion, usuarioCreacion, fechaUltModificacion,usuarioUltModificacion );

            modelo.put("exito", "exito");
            return "redirect:../listar";

        } catch (Exception e) {
            modelo.put("efector", efectorServicio.buscarEfectorPorId(id));
            modelo.put("error", e.getMessage());

            return "efector_editar.html";
        }
    }
}
