package com.ceiba.usuario.controlador;

import com.ceiba.usuario.comando.ComandoAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorPagarAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alquiler")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {

    private final ManejadorCrearAlquiler manejadorCrearAlquiler;
    private final ManejadorPagarAlquiler manejadorPagarAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler, ManejadorPagarAlquiler manejadorPagarAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
        this.manejadorPagarAlquiler = manejadorPagarAlquiler;
    }

    @PostMapping(path = "/crear")
    @ApiOperation("Crear Alquiler")
    public void crear(@RequestBody ComandoAlquiler comandoAlquiler) {
        manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }

    @PostMapping(path = "/pagar")
    @ApiOperation("Pagar Alquiler")
    public void pagar(@RequestBody Long nationalId) {
        manejadorPagarAlquiler.ejecutar(nationalId);
    }


}
