package com.coppel.examen.repositories;

import com.coppel.examen.models.EmpleadoModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Long> {
}
