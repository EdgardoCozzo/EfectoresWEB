package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Proveedores;

import com.example.Efectores.enumeraciones.Pais;
import com.example.Efectores.repositorios.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedores> getAllProveedores() {
        return (List<Proveedores>) proveedorRepository.findAll();
    }

    @Override
    public Proveedores getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedores saveProveedor(String nombre, String domicilio, String telefono1, String telefono2,
                                     String cuit, String email, String nombreDepartamento, String nombreProvincia,
                                     String nombrePais) {
        Proveedores proveedor = new Proveedores();
        proveedor.setNombre(nombre);
        proveedor.setDomicilio(domicilio);
        proveedor.setTelefono1(telefono1);
        proveedor.setTelefono2(telefono2);
        proveedor.setCuit(cuit);
        proveedor.setEmail(email);
        proveedor.setNombreDepartamento(nombreDepartamento);
        proveedor.setNombreProvincia(nombreProvincia);
        proveedor.setNombrePais(nombrePais);
        return proveedorRepository.save(proveedor);
    }


    @Override
    public Proveedores updateProveedor(Long id, Proveedores proveedor) {
        Proveedores proveedorActual = proveedorRepository.findById(id).orElse(null);
        if (proveedorActual != null) {
            proveedorActual.setNombre(proveedor.getNombre());
            proveedorActual.setDomicilio(proveedor.getDomicilio());

            proveedorActual.setNombrePais(proveedor.getNombrePais());
            proveedorActual.setNombreProvincia(proveedor.getNombreProvincia());
            proveedorActual.setNombreDepartamento(proveedor.getNombreDepartamento());

            proveedorActual.setCuit(proveedor.getCuit());
            proveedorActual.setTelefono1(proveedor.getTelefono1());
            proveedorActual.setTelefono2(proveedor.getTelefono2());
            proveedorActual.setEmail(proveedor.getEmail());
            return proveedorRepository.save(proveedorActual);
        }
        return null;
    }

    @Override
    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
