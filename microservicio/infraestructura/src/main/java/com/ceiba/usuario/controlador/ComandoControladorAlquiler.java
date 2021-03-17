package com.ceiba.usuario.controlador;

import com.ceiba.usuario.comando.ComandoAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alquiler")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {

    private final ManejadorCrearAlquiler manejadorCrearAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
    }

    @PostMapping
    @ApiOperation("Crear Alquiler")
    public void crear(@RequestBody ComandoAlquiler comandoAlquiler) {
        manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }


}
