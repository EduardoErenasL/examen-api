package com.coppel.examen.repositories;

import com.coppel.examen.models.PolizasModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

@Repository
public interface PolizasRepository extends CrudRepository<PolizasModel, Long>{

}
