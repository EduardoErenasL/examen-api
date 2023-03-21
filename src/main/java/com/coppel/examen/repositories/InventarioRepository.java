package com.coppel.examen.repositories;

import com.coppel.examen.models.InventarioModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface InventarioRepository extends CrudRepository<InventarioModel, String> {
}
