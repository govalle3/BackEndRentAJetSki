package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioCrearAlquiler(repositorioAlquiler);
    }

    @Bean
    public ServicioPagarAlquiler servicioPagarAlquiler() {
        return new ServicioPagarAlquiler();
    }

	

}
