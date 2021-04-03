package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.comando.dtoComando.ComandoUsuarioAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquilerUsuarioNuevo;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquilerUsuarioRegistrado;
import com.ceiba.usuario.comando.manejador.ManejadorPagarAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorMontoAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/gestionar-alquiler")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {

    private final ManejadorCrearAlquilerUsuarioRegistrado manejadorCrearAlquilerUsuarioRegistrado;
    private final ManejadorMontoAlquiler manejadorMontoAlquiler;
    private final ManejadorCrearAlquilerUsuarioNuevo manejadorCrearAlquilerUsuarioNuevo;
    private final ManejadorPagarAlquiler manejadorPagoAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquilerUsuarioRegistrado manejadorCrearAlquilerUsuarioRegistrado, ManejadorMontoAlquiler manejadorMontoAlquiler, ManejadorCrearAlquilerUsuarioNuevo manejadorCrearAlquilerUsuarioNuevo, ManejadorPagarAlquiler manejadorPagoAlquiler) {
        this.manejadorCrearAlquilerUsuarioRegistrado = manejadorCrearAlquilerUsuarioRegistrado;
        this.manejadorMontoAlquiler = manejadorMontoAlquiler;
        this.manejadorCrearAlquilerUsuarioNuevo = manejadorCrearAlquilerUsuarioNuevo;
        this.manejadorPagoAlquiler = manejadorPagoAlquiler;
    }

    @PostMapping(path = "/usuarios/alquiler")
    @ApiOperation("Crea Usuario y un alquiler")
    public ComandoRespuesta<Long> registrarAlquilerUsuarioNuevo(@RequestBody ComandoUsuarioAlquiler comandoUsuarioAlquiler){
        return manejadorCrearAlquilerUsuarioNuevo.ejecutar(comandoUsuarioAlquiler);
    }

    @PostMapping(path = "/usuarios-registrados/alquiler")
    @ApiOperation("Crear Alquiler con usuario registrado")
    public ComandoRespuesta<Long> registrarAlquilerUsuarioRegistrado(@RequestBody ComandoAlquiler comandoAlquiler) {
        return manejadorCrearAlquilerUsuarioRegistrado.ejecutar(comandoAlquiler);
    }

    @PostMapping(path = "/usuario/monto")
    @ApiOperation("Calcula monto renta alquiler")
    public double calcularMontoAlquiler(@RequestParam("cedula") String cedula, @RequestParam("fechaYHoraEntrega") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaYHoraEntrega) {
        long lonNationalId = Long.parseLong(cedula);
        return manejadorMontoAlquiler.ejecutar(lonNationalId, fechaYHoraEntrega);
    }

    @PutMapping(path = "/usuario/pago") //
    @ApiOperation("Paga un Alquiler según el monto")
    public void pagoMontoAlquiler(@RequestParam("cedula") String cedula) {
        long lonNationalId = Long.parseLong(cedula);
        manejadorPagoAlquiler.ejecutar(lonNationalId);
    }

}
