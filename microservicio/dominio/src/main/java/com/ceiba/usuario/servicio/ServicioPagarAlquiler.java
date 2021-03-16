package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.Duration;
import java.time.LocalTime;

public class ServicioPagarAlquiler {

    private final RepositorioUsuario repositorioUsuario;
    double multaMinuto = 0.8;

    public ServicioPagarAlquiler(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    public boolean pagarAlquiler(Usuario usuario) {
        validarTiempo(usuario);
        return this.repositorioUsuario.pagarAlquiler(usuario);
    }

    private void validarTiempo(Usuario usuario) {

    }

    private double calcularValorMulta(Usuario usuario, double valorMinuto) {
        double totalMulta = 0;
        Integer minRent = usuario.getRentTime();
        LocalTime rentTimeUser = usuario.getDateAndTimeRent().toLocalTime();
        LocalTime localTime = LocalTime.now();
        Integer duration  = Long.valueOf(Duration.between(rentTimeUser, localTime).toMinutes()).intValue();
        if(duration > minRent){
            int minutosPasados = duration - minRent;
            totalMulta = minutosPasados * multaMinuto * valorMinuto;
        }
        return totalMulta;
    }
}
