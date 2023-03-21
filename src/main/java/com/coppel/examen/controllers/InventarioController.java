package com.coppel.examen.controllers;

import com.coppel.examen.Utils.Data;
import com.coppel.examen.Utils.Meta;
import com.coppel.examen.Utils.WebResponse;
import com.coppel.examen.models.InventarioModel;
import com.coppel.examen.services.InventarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    private static final Logger logger = LogManager.getLogger(InventarioController.class);

    @Autowired
    InventarioService inventarioService;

    @GetMapping()
    public ResponseEntity<WebResponse> obtenerInventarios() {
        try {
            WebResponse response = new WebResponse();

            ArrayList<InventarioModel> articulos = inventarioService.obtenerInventarios();

            response.setData(articulos);
            response.setMeta(new Meta("OK"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 7, "Ha ocurrido un error al obtener los articulos", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error al obtener los articulos."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<WebResponse> guardarInventario(@RequestBody InventarioModel inventario) {
        try {
            WebResponse response = new WebResponse();

            InventarioModel articulocreado = inventarioService.guardarInventario(inventario);

            response.setData(articulocreado);
            response.setMeta(new Meta("OK"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.CREATED);
        } catch (Exception error) {
            logger.error("code: {} , msg: {}, details: {}", 8, "Ha ocurrido un error en grabado del articulo", error.getMessage());

            WebResponse response = new WebResponse();
            response.setData(new Data("Ha ocurrido un error en grabado del articulo."));
            response.setMeta(new Meta("FAILURE"));

            return new ResponseEntity<WebResponse>(response, null, HttpStatus.OK);
        }
    }
}
