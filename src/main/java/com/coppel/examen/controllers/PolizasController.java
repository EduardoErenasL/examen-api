package com.coppel.examen.controllers;

import com.coppel.examen.Utils.Meta;
import com.coppel.examen.Utils.Data;
import com.coppel.examen.Utils.WebResponse;
import com.coppel.examen.models.PolizasModel;
import com.coppel.examen.services.PolizasService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping("/poliza")
public class PolizasController {
    private static final Logger logger = LogManager.getLogger(PolizasController.class);
    @Autowired
    PolizasService polizasService;

    @GetMapping()
    public ResponseEntity<WebResponse> obtenerPolizas() {
        try {
            WebResponse response = new WebResponse();

            ArrayList<PolizasModel> listaPolizas = polizasService.obtenerPolizas();
            response.setData(listaPolizas);
            response.setMeta(new Meta("OK"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 1, "Ha ocurrido un error al consultar las pólizas", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error al consultar las pólizas."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<WebResponse> guardarPoliza(@RequestBody PolizasModel poliza) {
        try {
            WebResponse response = new WebResponse();

            poliza.setFecha(LocalDate.now());


            PolizasModel polizaGuardada = polizasService.guardarPoliza(poliza);

            response.setData(polizaGuardada);
            response.setMeta(new Meta("OK"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.CREATED);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 2, "Ha ocurrido un error en los grabados de póliza", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error en los grabados de póliza."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<WebResponse> actulizarPoliza(@PathVariable("id") Long id, @RequestBody PolizasModel poliza) {
        try {
            WebResponse response = new WebResponse();

            PolizasModel polizaActualizada = polizasService.actualizarpoliza(id, poliza);
            response.setData(polizaActualizada);
            response.setMeta(new Meta("OK"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 3, "Ha ocurrido un error al intentar actualizar la póliza", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error al intentar actualizar la póliza."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<WebResponse> eliminarPoliza(@PathVariable("id") Long id) {
        try {
            WebResponse response = new WebResponse();

            boolean ok = polizasService.eliminarPoliza(id);

            if (ok) {
                response.setMeta(new Meta("OK"));
                response.setData(new Data("Se eliminó correctamente la póliza " + id));
            } else {
                response.setMeta(new Meta("FAILURE"));
                response.setData(new Data("Ha ocurrido un error al intentar eliminar la póliza " + id));
            }

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 4, "Ha ocurrido un error al intentar eliminar la póliza", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error al intentar eliminar la póliza."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }
}
