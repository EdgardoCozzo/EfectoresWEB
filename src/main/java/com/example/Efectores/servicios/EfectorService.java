package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Efector;


import java.util.List;

public interface EfectorService {
    List<Efector> getAllEfectores();

    Efector getEfectoresById(Long id);

    Efector saveEfector(String nombre, String domicilio, String telefono1, String telefono2,
                              String cuit, String email, String nombreDepartamento, String nombreProvincia,
                              String nombrePais);

    Efector updateEfector(Long id, Efector efector);

    void deleteEfector(Long id);
}
