package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;
import java.time.*;
import static org.junit.Assert.*;

public class ServicioPagarAlquilerTest {

    @Test
    public void pagarAlquilerJetSkiPrecio1SinMulta() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC01").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 13, 00)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,446000,0);
    }


    @Test
    public void pagarAlquilerJetSkiPrecio1ConMulta() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC03").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,90000,0);
    }
}