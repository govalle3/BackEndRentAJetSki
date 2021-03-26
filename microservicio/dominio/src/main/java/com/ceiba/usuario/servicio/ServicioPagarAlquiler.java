package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioPagarAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;

    double multaMinuto = 1.2;

    public ServicioPagarAlquiler(RepositorioAlquiler repositorioAlquiler) {

        this.repositorioAlquiler = repositorioAlquiler;

    }

    public double pagarAlquiler(Alquiler alquiler, LocalDateTime dateAndTimeCheckout) {

        double valorMinuto = validarValorMinuto(alquiler);
        double totalMulta = calcularSiHayMultaYPagoParcial(alquiler, valorMinuto, dateAndTimeCheckout);
        return sumaPagoParcialYPagoTotal(alquiler, valorMinuto, totalMulta);

    }

    public double validarValorMinuto(Alquiler alquiler) {

        String idJetSki = alquiler.getIdJetSki();

        double valorMinuto = 0;
        double PrecioMoto1 = 5000;
        double PrecioMoto2 = 7000;
        double PrecioMoto3 = 9000;

        if (idJetSki.equals("BC001")) {

            valorMinuto = PrecioMoto1;

        }

        if (idJetSki.equals("BC002")) {

            valorMinuto = PrecioMoto2;

        }

        if (idJetSki.equals("BC003")) {

            valorMinuto = PrecioMoto3;

        }

        return valorMinuto;

    }

    public double calcularSiHayMultaYPagoParcial(Alquiler alquiler, double valorMinuto, LocalDateTime dateAndTimeCheckout) { // separar metodos en 2

        double totalMulta = 0;

        Integer tiempoRentado = alquiler.getRentTime();

        LocalTime fechaYHoraRentaUsuario = alquiler.getDateAndTimeRent().toLocalTime();

        LocalTime localTime = dateAndTimeCheckout.toLocalTime();

        Integer duracion = Long.valueOf(Duration.between(fechaYHoraRentaUsuario, localTime).toMinutes()).intValue();

        if (duracion > tiempoRentado) {

            int minutosPasados = duracion - tiempoRentado;

            totalMulta = minutosPasados * multaMinuto * valorMinuto;

        }

        return totalMulta;

    }

    public double sumaPagoParcialYPagoTotal(Alquiler alquiler, double valorMinuto, double totalMulta) {

        double totalAPagar = 0;

        double totalParcial = 0;

        Integer tiempoRentado = alquiler.getRentTime();

        totalParcial = valorMinuto * tiempoRentado;

        totalAPagar = totalParcial + totalMulta;

        return totalAPagar;

    }

}
