package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.ServicioLiberarAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioMontoAlquiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, DaoAlquiler daoAlquiler) {
        return new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);
    }

    @Bean
    public ServicioMontoAlquiler servicioPagarAlquiler() {
        return new ServicioMontoAlquiler();
    }

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(ServicioCrearAlquiler servicioCrearAlquiler, DaoAlquiler daoAlquiler) {
        return new ServicioCrearUsuario(servicioCrearAlquiler, daoAlquiler);
    }

    @Bean
    public ServicioLiberarAlquiler servicioCheckoutAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioLiberarAlquiler(repositorioAlquiler);
    }

	

}
