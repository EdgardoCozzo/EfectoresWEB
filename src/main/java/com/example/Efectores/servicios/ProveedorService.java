package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Proveedores;

import java.util.List;

public interface ProveedorService {

    List<Proveedores> getAllProveedores();

    Proveedores getProveedorById(Long id);

    Proveedores saveProveedor(String nombre, String domicilio, String telefono1, String telefono2,
                              String cuit, String email, String nombreDepartamento, String nombreProvincia,
                              String nombrePais);

    Proveedores updateProveedor(Long id, Proveedores proveedor);

    void deleteProveedor(Long id);
}
