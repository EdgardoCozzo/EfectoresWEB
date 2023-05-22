package com.example.Efectores.controladores;

import com.example.Efectores.entidades.Efector;
import com.example.Efectores.enumeraciones.Departamento;
import com.example.Efectores.enumeraciones.Pais;
import com.example.Efectores.enumeraciones.Provincia;
import com.example.Efectores.servicios.EfectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/efector")
public class EfectorController {

    @Autowired
    EfectorServiceImpl efectorService;

    @GetMapping("/crear")
    public String crear(ModelMap modelo){

        modelo.addAttribute("paises", Pais.values());
        modelo.addAttribute("provincias", Provincia.values());
        modelo.addAttribute("departamentos", Departamento.values());

        return "efector_crear.html";

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
            efectorService.saveEfector(nombre, domicilio, telefono1, telefono2, cuit, email, nombreDepartamento, nombreProvincia, nombrePais);

            modelo.put("exito", "El efector fue cargado correctamente!");
            modelo.addAttribute("efector", efectorService.getAllEfectores());

            return "efector_listar.html";

        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            return "efector_crear.html";
        }
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelo) {
        List<Efector> efector = efectorService.getAllEfectores();
        if (!efector.isEmpty()) {
            modelo.addAttribute("proveedor", efector);
        }
        return "efector_listar.html";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {
        modelo.put("efector", efectorService.getEfectoresById(id));

        modelo.addAttribute("paises", Pais.values());
        modelo.addAttribute("provincias", Provincia.values());
        modelo.addAttribute("departamentos", Departamento.values());

        return "efector_editar.html";
    }


    @PostMapping("/editar/{id}")
    public String modificarEfector(@PathVariable Long id, Efector efector, ModelMap modelo) {

        try {
            efectorService.updateEfector(id, efector);

            modelo.put("exito", "exito");
            return "redirect:../listar";

        } catch (Exception e) {
            modelo.put("efector", efectorService.getEfectoresById(id));
            modelo.put("error", e.getMessage());

            return "efector_editar.html";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEfector(@PathVariable Long id, ModelMap modelo) {
        efectorService.deleteEfector(id);
        return "redirect:/efector/listar";
    }
}
