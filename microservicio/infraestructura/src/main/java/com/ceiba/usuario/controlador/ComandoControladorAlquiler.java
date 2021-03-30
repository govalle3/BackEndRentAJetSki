package com.ceiba.usuario.controlador;

import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorLiberarAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorMontoAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gestionar-alquiler")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {

    private final ManejadorCrearAlquiler manejadorCrearAlquiler;
    private final ManejadorMontoAlquiler manejadorMontoAlquiler;
    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorLiberarAlquiler manejadorLiberarAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler, ManejadorMontoAlquiler manejadorMontoAlquiler, ManejadorCrearUsuario manejadorCrearUsuario, ManejadorLiberarAlquiler manejadorLiberarAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
        this.manejadorMontoAlquiler = manejadorMontoAlquiler;
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorLiberarAlquiler = manejadorLiberarAlquiler;
    }

    @PostMapping(path = "/gestionar-usuarios/alquilar")
    @ApiOperation("Crea Usuario y un alquiler")
    public void crear(@RequestBody ComandoAlquiler comandoAlquiler ){
        manejadorCrearUsuario.registrar(comandoAlquiler);
    }

    @PostMapping(path = "/usuarios-registrados/alquilar")
    @ApiOperation("Crear Alquiler con usuario registrado")
    public void registrarAlquilerUsuarioRegistrado(@RequestParam("nationalId") String nationalId, @RequestParam("idJetSki") String idJetSki, @RequestParam("rentTime") Integer rentTime, @RequestParam("dateAndTimeRent") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateAndTimeRent) {
        long lonNationalId = Long.parseLong(nationalId);
        manejadorCrearAlquiler.ejecutar(lonNationalId, idJetSki, rentTime,dateAndTimeRent);
    }

    @PostMapping(path = "/gestionar-montos/monto")
    @ApiOperation("Calcular valor renta alquiler")
    public double montoTotal(@RequestParam("nationalId") String nationalId, @RequestParam("dateAndTimeCheckout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateAndTimeCheckout) {
        long lonNationalId = Long.parseLong(nationalId);
        return manejadorMontoAlquiler.ejecutar(lonNationalId, dateAndTimeCheckout);
    }

    @PutMapping(path = "/gestionar-pago") //
    @ApiOperation("Actualiza estado Alquiler")
    public void actualizarPago(@RequestParam("nationalId") String nationalId) {
        long lonNationalId = Long.parseLong(nationalId);
        manejadorLiberarAlquiler.actualizar(lonNationalId);
    }

}
