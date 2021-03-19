package com.ceiba.usuario.controlador;

import java.util.List;

import com.ceiba.usuario.consulta.ManejadorListarAlquiler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alquiler")
@Api(tags={"Controlador consulta alquiler"})
public class ConsultaControladorAlquiler {

    private final ManejadorListarAlquiler manejadorListarAlquiler;

    public ConsultaControladorAlquiler(ManejadorListarAlquiler manejadorListarAlquiler) {
        this.manejadorListarAlquiler = manejadorListarAlquiler;
    }

    @GetMapping(path = "/listar")
    @ApiOperation("Listar Alquiler")
    public List<DtoAlquiler> listar() {

        return this.manejadorListarAlquiler.ejecutar();
    }

}
