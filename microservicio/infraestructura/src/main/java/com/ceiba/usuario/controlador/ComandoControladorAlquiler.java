package com.ceiba.usuario.controlador;

import com.ceiba.usuario.comando.ComandoAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorPagarAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;


@CrossOrigin(origins = "*")
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
    public void crear(@RequestBody ComandoAlquiler comandoAlquiler ){
        manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }

    @PostMapping(path = "/pagar")
    @ApiOperation("Pagar Alquiler")
    public double pagar(@RequestParam("nationalId") Long nationalId, @RequestParam("dateAndTimeCheckout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateAndTimeCheckout) {
        return manejadorPagarAlquiler.ejecutar(nationalId, dateAndTimeCheckout);
    }

}
