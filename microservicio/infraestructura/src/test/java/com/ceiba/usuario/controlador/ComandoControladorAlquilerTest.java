package com.ceiba.usuario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.comando.dtoComando.ComandoUsuarioAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoAlquilerTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioAlquilerTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.Month;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAlquiler.class)
public class ComandoControladorAlquilerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Test
    public void crearAlquilerUsuarioNuevo() throws Exception{
        // arrange
        ComandoUsuarioAlquiler comandoUsuarioAlquiler = new ComandoUsuarioAlquilerTestDataBuilder().conCedula(123456L).build();
        // act - assert
        mocMvc.perform(post("/gestionar-alquiler/usuarios/alquiler")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoUsuarioAlquiler)))
                .andExpect(status().isOk());

    }

    @Test
    public void registrarAlquilerUsuarioRegistrado() throws Exception{
        // arrange
        ComandoAlquiler comandoAlquiler = new ComandoAlquilerTestDataBuilder().conNationalId(51658L).conIdJetSki("BC002").conRentTime(15).conDateAndTimeRent(LocalDateTime.of(2021,Month.MARCH,01,11,10,00)).build();

        // act - assert
        mocMvc.perform(post("/gestionar-alquiler/usuarios-registrados/alquiler")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoAlquiler)))
                .andExpect(status().isOk());

    }

    @Test
    public void calcularMontoAlquiler() throws Exception{
        // Arrange
        // act - assert
        mocMvc.perform(post("/gestionar-alquiler/usuario/monto?cedula=1234&fechaYHoraEntrega=2021-03-31T09:30:00")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("50000.0")); // calculo monto;
    }

}

