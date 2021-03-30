package com.ceiba.configuracion;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorLiberarAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorMontoAlquiler;

import com.ceiba.usuario.servicio.ServicioLiberarAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioMontoAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanManejador {


    // instancia los datos
    @Bean
    public ManejadorCrearAlquiler manejadorCrearAlquiler(com.ceiba.usuario.comando.fabrica.FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler, DaoAlquiler daoAlquiler) {
        return new ManejadorCrearAlquiler(fabricaAlquiler, servicioCrearAlquiler, daoAlquiler);
    }

    @Bean
    public ManejadorMontoAlquiler manejadorPagarAlquiler(ServicioMontoAlquiler servicioMontoAlquiler, com.ceiba.usuario.comando.fabrica.FabricaAlquiler fabricaAlquiler, DaoAlquiler daoAlquiler) {
        return new ManejadorMontoAlquiler(servicioMontoAlquiler, fabricaAlquiler, daoAlquiler);
    }

    @Bean
    public ManejadorCrearUsuario manejadorCrearUsuario(FabricaAlquiler fabricaAlquiler, ServicioCrearUsuario servicioCrearUsuario, DaoAlquiler daoAlquiler) {
        return new ManejadorCrearUsuario(fabricaAlquiler, servicioCrearUsuario, daoAlquiler);
    }


    @Bean
    public ManejadorLiberarAlquiler manejadorCheckoutAlquiler(ServicioLiberarAlquiler servicioLiberarAlquiler, FabricaAlquiler fabricaAlquiler, DaoAlquiler daoAlquiler){
        return new ManejadorLiberarAlquiler(servicioLiberarAlquiler, fabricaAlquiler, daoAlquiler);
    }


}
