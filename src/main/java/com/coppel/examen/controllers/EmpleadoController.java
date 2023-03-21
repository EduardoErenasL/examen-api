package com.coppel.examen.controllers;

import com.coppel.examen.Utils.Data;
import com.coppel.examen.Utils.Meta;
import com.coppel.examen.Utils.WebResponse;
import com.coppel.examen.models.EmpleadoModel;
import com.coppel.examen.services.EmpleadoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private static final Logger logger = LogManager.getLogger(EmpleadoController.class);
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ResponseEntity<WebResponse> obtenerEmpleados() {
        try {
            WebResponse response = new WebResponse();

            ArrayList<EmpleadoModel> empleados = empleadoService.obtenerEmpleados();

            response.setData(empleados);
            response.setMeta(new Meta("OK"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 5, "Ha ocurrido un error al obtener los empleados", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error al obtener los empleados."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<WebResponse> guardarEmpleado(@RequestBody EmpleadoModel empleado) {
        try {
            WebResponse response = new WebResponse();

            EmpleadoModel empleadoCreado = empleadoService.guardarEmpleado(empleado);

            response.setData(empleadoCreado);
            response.setMeta(new Meta("OK"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.CREATED);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 6, "Ha ocurrido un error en grabado del empleado", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error en grabado del empleado."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }
}
