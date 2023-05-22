package com.example.Efectores.servicios;

import com.example.Efectores.entidades.Efector;
import com.example.Efectores.repositorios.EfectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EfectorServiceImpl implements EfectorService {

    private final EfectorRepository efectorRepository;

    public EfectorServiceImpl(EfectorRepository efectorRepository) {
        this.efectorRepository = efectorRepository;
    }

    @Override
    public List<Efector> getAllEfectores() {
        return (List<Efector>) efectorRepository.findAll();
    }

    @Override
    public Efector getEfectoresById(Long id) {
        return efectorRepository.findById(id).orElse(null);
    }

    @Override
    public Efector saveEfector(String nombre, String domicilio, String telefono1, String telefono2, String cuit, String email, String nombreDepartamento, String nombreProvincia, String nombrePais) {
        Efector efector = new Efector();
        efector.setNombre(nombre);
        efector.setDomicilio(domicilio);
        efector.setTelefono1(telefono1);
        efector.setTelefono2(telefono2);
        efector.setCuit(cuit);
        efector.setEmail(email);
        efector.setNombreDepartamento(nombreDepartamento);
        efector.setNombreProvincia(nombreProvincia);
        efector.setNombrePais(nombrePais);
        return efectorRepository.save(efector);
    }

    @Override
    public Efector updateEfector(Long id, Efector efector) {
        Efector efectorActual = efectorRepository.findById(id).orElse(null);
        if (efectorActual != null) {
            efectorActual.setNombre(efector.getNombre());
            efectorActual.setDomicilio(efector.getDomicilio());

            efectorActual.setNombrePais(efector.getNombrePais());
            efectorActual.setNombreProvincia(efector.getNombreProvincia());
            efectorActual.setNombreDepartamento(efector.getNombreDepartamento());

            efectorActual.setCuit(efector.getCuit());
            efectorActual.setTelefono1(efector.getTelefono1());
            efectorActual.setTelefono2(efector.getTelefono2());
            efectorActual.setEmail(efector.getEmail());
            return efectorRepository.save(efectorActual);
        }
        return null;
    }

    @Override
    public void deleteEfector(Long id) {
        efectorRepository.deleteById(id);

    }
}
