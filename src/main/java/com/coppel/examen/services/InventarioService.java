package com.coppel.examen.services;

import com.coppel.examen.models.InventarioModel;
import com.coppel.examen.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InventarioService {
    @Autowired
    InventarioRepository inventarioRepository;

    public ArrayList<InventarioModel> obtenerInventarios() {
        return (ArrayList<InventarioModel>) inventarioRepository.findAll();
    }

    public InventarioModel guardarInventario(InventarioModel inventario) {
        return inventarioRepository.save(inventario);
    }
}
