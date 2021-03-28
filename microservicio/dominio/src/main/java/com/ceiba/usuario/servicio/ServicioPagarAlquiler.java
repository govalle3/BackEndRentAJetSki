package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioPagarAlquiler {

    public static final double PRECIOMOTO1 = 5000;
    public static final double PRECIOMOTO2 = 7000;
    public static final double PRECIOMOTO3 = 9000;
    public static final double MULTAMINUTO = 1.2;
    private double valorMinuto = 0;
    private double totalMulta = 0;

    private final RepositorioAlquiler repositorioAlquiler;


    public ServicioPagarAlquiler(RepositorioAlquiler repositorioAlquiler) {


        this.repositorioAlquiler = repositorioAlquiler;
    }

    public double pagarAlquiler(Alquiler alquiler, LocalDateTime dateAndTimeCheckout) {

        valorMinuto = validarValorMinuto(alquiler);
        totalMulta = calcularSiHayMultaYPagoParcial(alquiler, valorMinuto, dateAndTimeCheckout);
        return sumaPagoParcialYPagoTotal(alquiler, valorMinuto, totalMulta);

    }

    public double validarValorMinuto(Alquiler alquiler) {

        String idJetSki = alquiler.getIdJetSki();


        if ("BC001".equals(idJetSki)) {
            valorMinuto = PRECIOMOTO1;
        }

        if ("BC002".equals(idJetSki)) {
            valorMinuto = PRECIOMOTO2;
        }

        if ("BC003".equals(idJetSki)) {
            valorMinuto = PRECIOMOTO3;
        }

        return valorMinuto;

    }

    public double calcularSiHayMultaYPagoParcial(Alquiler alquiler, double valorMinuto, LocalDateTime dateAndTimeCheckout) { // separar metodos en 2

        Integer tiempoRentado = alquiler.getRentTime();

        LocalTime fechaYHoraRentaUsuario = alquiler.getDateAndTimeRent().toLocalTime();

        LocalTime localTime = dateAndTimeCheckout.toLocalTime();

        Integer duracion = Long.valueOf(Duration.between(fechaYHoraRentaUsuario, localTime).toMinutes()).intValue();

        if (duracion > tiempoRentado) {

            int minutosPasados = duracion - tiempoRentado;

            totalMulta = minutosPasados * MULTAMINUTO * valorMinuto;

        }

        return totalMulta;

    }

    public double sumaPagoParcialYPagoTotal(Alquiler alquiler, double valorMinuto, double totalMulta) {

        Integer tiempoRentado = alquiler.getRentTime();
        double totalParcial = valorMinuto * tiempoRentado;
        return totalParcial + totalMulta;

    }

}
