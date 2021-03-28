package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    private RepositorioAlquiler repositorioAlquiler;


    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, DaoAlquiler daoAlquiler) {
        return new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);
    }

    @Bean
    public ServicioPagarAlquiler servicioPagarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioPagarAlquiler(repositorioAlquiler);
    }

	

}
