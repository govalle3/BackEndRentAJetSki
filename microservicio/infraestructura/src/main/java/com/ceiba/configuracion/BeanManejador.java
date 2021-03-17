package com.ceiba.configuracion;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.usuario.comando.manejador.ManejadorPagarAlquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanManejador {


    @Bean
    public ManejadorCrearAlquiler manejadorCrearAlquiler(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler) {
        return new ManejadorCrearAlquiler(fabricaAlquiler, servicioCrearAlquiler);
    }

    @Bean
    public ManejadorPagarAlquiler manejadorPagarAlquiler(ServicioPagarAlquiler servicioPagarAlquiler, DaoAlquiler daoAlquiler) {
        return new ManejadorPagarAlquiler(servicioPagarAlquiler,daoAlquiler);
    }
}
