package com.coppel.examen.services;

import com.coppel.examen.models.EmpleadoModel;
import com.coppel.examen.models.InventarioModel;
import com.coppel.examen.models.PolizasModel;
import com.coppel.examen.repositories.EmpleadoRepository;
import com.coppel.examen.repositories.InventarioRepository;
import com.coppel.examen.repositories.PolizasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class PolizasService {
    @Autowired
    PolizasRepository polizasRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    InventarioRepository inventarioRepository;

    public ArrayList<PolizasModel> obtenerPolizas() {
        Object response = new Object();

        return (ArrayList<PolizasModel>) polizasRepository.findAll();
    }

    public PolizasModel guardarPoliza(PolizasModel poliza) throws Exception {
        Optional<EmpleadoModel> empleadoOpcional = empleadoRepository.findById(poliza.getEmpleado().getIdEmpleado());

        if (!empleadoOpcional.isPresent()) {
            throw new Exception("El empleado no existe");
        }

        Optional<InventarioModel> inventarioOpcional = inventarioRepository.findById(poliza.getArticulo().getSKU());

        if (!inventarioOpcional.isPresent()) {
            throw new Exception("El articulo no existe");
        }

        if (poliza.getCantidad() == 0 || poliza.getCantidad() < 0 || poliza.getCantidad() > inventarioOpcional.get().getCantidad()) {
            throw new Exception("La cantidad a descontar no es valida, verifique la informacion");
        }

        poliza.setEmpleado(empleadoOpcional.get());
        poliza.setArticulo(inventarioOpcional.get());

        PolizasModel polizaCreada = polizasRepository.save(poliza);
        InventarioModel articulo = inventarioOpcional.get();
        Integer nuevaCantidad = articulo.getCantidad() - poliza.getCantidad();
        articulo.setCantidad(nuevaCantidad);

        inventarioRepository.save(articulo);

        return polizaCreada;
    }

    public Optional<PolizasModel> obtenerPorId(Long id) {
        return polizasRepository.findById(id);
    }

    public PolizasModel actualizarpoliza(Long id, PolizasModel poliza) throws Exception {
        Long idPoliza = poliza.getIdPolizas();

        PolizasModel polizaActualizar = polizasRepository.findById(id).orElse(null);

        Optional<InventarioModel> inventarioOpcional = inventarioRepository.findById(polizaActualizar.getArticulo().getSKU());
        Integer diferencia = polizaActualizar.getCantidad() - poliza.getCantidad();
        Integer nuevoTotal = inventarioOpcional.get().getCantidad();

        nuevoTotal +=  diferencia;

        if ( nuevoTotal < 0 ) {
            throw new Exception("La cantidad a modificar no es valida, verifique la informacion");
        }

        polizaActualizar.setCantidad(poliza.getCantidad());

        PolizasModel polizaResponse =  polizasRepository.save(polizaActualizar);
        InventarioModel articulo = inventarioOpcional.get();
        articulo.setCantidad(nuevoTotal);
        inventarioRepository.save(articulo);

        return polizaResponse;
    }

    public boolean eliminarPoliza(long id) {
        try {
            polizasRepository.deleteById(id);

            return true;
        } catch (Exception error) {
            return false;
        }
    }

}
