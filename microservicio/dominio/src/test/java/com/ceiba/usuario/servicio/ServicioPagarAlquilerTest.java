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
                Month.MARCH, 18, 13, 59, 00)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(930000,930000,0);
    }

}