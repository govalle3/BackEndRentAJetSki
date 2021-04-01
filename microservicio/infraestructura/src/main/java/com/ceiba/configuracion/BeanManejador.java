package com.ceiba.configuracion;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquilerUsuarioNuevo;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquilerUsuarioRegistrado;
import com.ceiba.usuario.comando.manejador.ManejadorPagarAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorMontoAlquiler;

import com.ceiba.usuario.servicio.*;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanManejador {


    // instancia los datos
    @Bean
    public ManejadorCrearAlquilerUsuarioRegistrado manejadorCrearAlquilerUsuarioRegistrado(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler, ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia) {
        return new ManejadorCrearAlquilerUsuarioRegistrado(fabricaAlquiler, servicioCrearAlquiler, servicioValidarExistenciaUsuarioYPagosAlDia);
    }

    @Bean
    public ManejadorMontoAlquiler manejadorPagarAlquiler(ServicioCalcularMontoAlquiler servicioCalcularMontoAlquiler, com.ceiba.usuario.comando.fabrica.FabricaAlquiler fabricaAlquiler, DaoRentAJetSki daoRentAJetSki) {
        return new ManejadorMontoAlquiler(servicioCalcularMontoAlquiler, fabricaAlquiler, daoRentAJetSki);
    }

    @Bean
    public ManejadorCrearAlquilerUsuarioNuevo manejadorCrearAlquilerNuevoUsuario(FabricaAlquiler fabricaAlquiler, ServicioCrearUsuario servicioCrearUsuario, ServicioCrearAlquiler servicioCrearAlquiler, FabricaUsuario fabricaUsuario) {
        return new ManejadorCrearAlquilerUsuarioNuevo(fabricaAlquiler, servicioCrearUsuario, servicioCrearAlquiler, fabricaUsuario);
    }

    @Bean
    public ManejadorPagarAlquiler manejadorCheckoutAlquiler(ServicioPagarAlquiler servicioPagarAlquiler, FabricaAlquiler fabricaAlquiler, DaoRentAJetSki daoRentAJetSki){
        return new ManejadorPagarAlquiler(servicioPagarAlquiler, fabricaAlquiler, daoRentAJetSki);
    }


}
