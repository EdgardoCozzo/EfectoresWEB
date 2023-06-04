package com.example.Efectores.controladores;

import com.example.Efectores.entidades.Prestacion;
import com.example.Efectores.servicios.PrestacionServicioImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/prestacion")
public class PrestacionControlador {

    private final PrestacionServicioImpl prestacionServicio;

    public PrestacionControlador(PrestacionServicioImpl prestacionServicio) {
        this.prestacionServicio = prestacionServicio;
    }

    @GetMapping("/crear")
    public String crear(ModelMap modelo) {


        return "prestacion_crear.html";
    }

    @PostMapping("/creado")
    public String registro(
            @RequestParam String nombre,
            @RequestParam long idProveedor,
            LocalDate fechaCreacion,
            String usuarioCreacion,
            LocalDate fechaUltModificacion,
            String usuarioUltModificacion,
            ModelMap modelo) {

        try {
            prestacionServicio.guardarPrestacion(nombre, idProveedor, fechaCreacion,usuarioCreacion,
            fechaUltModificacion,usuarioUltModificacion);

            modelo.put("exito", "La Prestación fue cargada correctamente!");
            modelo.addAttribute("prestacion", prestacionServicio.listarPrestaciones());

            return "prestacion_listar.html";

        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            return "prestacion_crear.html";
        }
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelo) {
        List<Prestacion> prestaciones = prestacionServicio.listarPrestaciones();
        modelo.addAttribute("prestacion", prestaciones);

        return"prestacion_listar.html";
}

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {
        modelo.put("prestacion", prestacionServicio.buscarPrestacionPorId(id));

        return "prestacion_editar.html";
    }


    @PostMapping("/editar/{id}")
    public String modificarPrestacion(@PathVariable Long id,
                                     String nombre, long idProveedor,
                                     LocalDate fechaUltModificacion,
                                     String usuarioUltModificacion, ModelMap modelo) {

        try {
            prestacionServicio.modificarPrestacion(id,nombre, idProveedor, fechaUltModificacion,usuarioUltModificacion );

            modelo.put("exito", "exito");
            return "redirect:../listar";

        } catch (Exception e) {
            modelo.put("prestacion", prestacionServicio.buscarPrestacionPorId(id));
            modelo.put("error", e.getMessage());

            return "prestacion_editar.html";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPrestacion(@PathVariable Long id, ModelMap modelo) {
        prestacionServicio.eliminarPrestacion(id);
        return "redirect:/prestacion/listar";
    }

}
