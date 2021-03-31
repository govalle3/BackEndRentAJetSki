package com.ceiba.usuario.controlador;

import java.util.List;

import com.ceiba.usuario.consulta.ManejadorListarAlquiler;
import com.ceiba.usuario.consulta.ManejadorListarAlquilerPagados;
import com.ceiba.usuario.consulta.ManejadorListarAlquilerPorPagar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/gestionar-alquiler")
@Api(tags={"Controlador consulta alquiler"})
public class ConsultaControladorAlquiler {

    private final ManejadorListarAlquiler manejadorListarAlquiler;
    private final ManejadorListarAlquilerPagados manejadorListarAlquilerPagados;
    private final ManejadorListarAlquilerPorPagar manejadorListarAlquilerPorPagar;

    public ConsultaControladorAlquiler(ManejadorListarAlquiler manejadorListarAlquiler, ManejadorListarAlquilerPagados manejadorListarAlquilerPagados, ManejadorListarAlquilerPorPagar manejadorListarAlquilerPorPagar) {
        this.manejadorListarAlquiler = manejadorListarAlquiler;
        this.manejadorListarAlquilerPagados = manejadorListarAlquilerPagados;
        this.manejadorListarAlquilerPorPagar = manejadorListarAlquilerPorPagar;
    }

    @GetMapping(path = "/alquiler")
    @ApiOperation("Listar Alquiler todos")
    public List<DtoAlquiler> listarTodos() {
        return this.manejadorListarAlquiler.ejecutar();
    }

    @GetMapping(path = "/alquiler/pagados")
    @ApiOperation("Listar Alquileres pagados")
    public List<DtoAlquiler> listarPagados() {
        return this.manejadorListarAlquilerPagados.ejecutar();
    }

    @GetMapping(path = "/listar-por-pagar")
    @ApiOperation("Listar Alquileres por pagar")
    public List<DtoAlquiler> listarPorPagar() {
        return this.manejadorListarAlquilerPorPagar.ejecutar();
    }

}
