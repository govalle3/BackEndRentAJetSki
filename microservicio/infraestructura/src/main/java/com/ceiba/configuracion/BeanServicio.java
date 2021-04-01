package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;
import com.ceiba.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioRentAJetSki repositorioRentAJetSki, DaoRentAJetSki daoRentAJetSki) {
        return new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
    }

    @Bean
    public ServicioCalcularMontoAlquiler servicioPagarAlquiler() {
        return new ServicioCalcularMontoAlquiler();
    }

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioRentAJetSki repositorioRentAJetSki, DaoRentAJetSki daoRentAJetSki) {
        return new ServicioCrearUsuario(repositorioRentAJetSki, daoRentAJetSki);
    }

    @Bean
    public ServicioPagarAlquiler servicioCheckoutAlquiler(RepositorioRentAJetSki repositorioRentAJetSki) {
        return new ServicioPagarAlquiler(repositorioRentAJetSki);
    }

    @Bean
    public ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia(DaoRentAJetSki daoRentAJetSki){
        return new ServicioValidarExistenciaUsuarioYPagosAlDia(daoRentAJetSki);
    }
}
