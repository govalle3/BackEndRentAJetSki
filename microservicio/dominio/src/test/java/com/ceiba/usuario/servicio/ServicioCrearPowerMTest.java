package com.ceiba.usuario.servicio;

import org.junit.Before;
import org.junit.Test;

import java.time.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class ServicioCrearPowerMTest {
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pruebaFecha(){
        //Arrange datos necesarios para que la prueba funcione
        LocalDateTime localDateTime = Mock(LocalDateTime.class);
        when(LocalDateTime.now()).thenReturn(LocalDateTime.of(2021,
                Month.MARCH, 17, 14, 24, 00));
        Clock clock = Clock.fixed(Instant.parse("2014-12-23T10:15:30.00Z"), ZoneId.of("UTC"));
        LocalDateTime dateTimeExpected = LocalDateTime.now(clock);
        // act invocar el metodo para probar
        LocalDateTime now = LocalDateTime.now();
        // assert comprobar los datos devueltos con los esperados
        assertEquals(now.toString(), dateTimeExpected);

    }


}
