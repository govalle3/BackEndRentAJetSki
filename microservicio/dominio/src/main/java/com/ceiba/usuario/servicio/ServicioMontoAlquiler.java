package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioMontoAlquiler {

    public static final double PRECIO_MOTO_1_5000 = 5000;
    public static final double PRECIO_MOTO_2_7000 = 7000;
    public static final double PRECIO_MOTO_3_9000 = 9000;
    public static final double MULTA_MINUTO_1_2 = 1.2;
    private double valorMinuto = 0;
    private double totalMulta = 0;

    public double pagarAlquiler(Alquiler alquiler, LocalDateTime dateAndTimeCheckout) {

        valorMinuto = validarValorMinuto(alquiler);
        totalMulta = calcularSiHayMultaYPagoParcial(alquiler, valorMinuto, dateAndTimeCheckout);
        return sumaPagoParcialYPagoTotal(alquiler, valorMinuto, totalMulta);

    }

    public double validarValorMinuto(Alquiler alquiler) {

        String idJetSki = alquiler.getIdJetSki();


        if ("BC001".equals(idJetSki)) {
            valorMinuto = PRECIO_MOTO_1_5000;
        }

        if ("BC002".equals(idJetSki)) {
            valorMinuto = PRECIO_MOTO_2_7000;
        }

        if ("BC003".equals(idJetSki)) {
            valorMinuto = PRECIO_MOTO_3_9000;
        }

        return valorMinuto;

    }

    public double calcularSiHayMultaYPagoParcial(Alquiler alquiler, double valorMinuto, LocalDateTime dateAndTimeCheckout) { // separar methods en 2

        Integer tiempoRentado = alquiler.getRentTime();
        LocalTime fechaYHoraRentaUsuario = alquiler.getDateAndTimeRent().toLocalTime();
        LocalTime localTime = dateAndTimeCheckout.toLocalTime();
        Long duracion = Duration.between(fechaYHoraRentaUsuario, localTime).toMinutes();

        if (duracion > tiempoRentado) {
            long minutosPasados = duracion - tiempoRentado;
            totalMulta = minutosPasados * MULTA_MINUTO_1_2 * valorMinuto;

        }

        return totalMulta;

    }

    public double sumaPagoParcialYPagoTotal(Alquiler alquiler, double valorMinuto, double totalMulta) {

        Integer tiempoRentado = alquiler.getRentTime();
        double totalParcial = valorMinuto * tiempoRentado;
        return totalParcial + totalMulta;

    }



}
