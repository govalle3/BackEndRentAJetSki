package com.ceiba.usuario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        ComandoUsuarioAlquiler comandoUsuarioAlquiler = new ComandoUsuarioAlquilerTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/gestionar-alquiler/usuarios/alquiler")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoUsuarioAlquiler)))
                .andExpect(status().isOk());

    }

    @Test
    public void registrarAlquilerUsuarioRegistrado() throws Exception{
        // arrange
        ComandoAlquiler comandoAlquiler = new ComandoAlquilerTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/gestionar-alquiler/usuarios-registrados/alquiler?cedula=51658659&idJetSki=BC001&tiempoRenta=11&fechaYHoraRenta=2021-03-29T21:00:00")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoAlquiler)))
                .andExpect(status().isOk());

    }

    @Test
    public void calcularMontoAlquiler() throws Exception{
        // Arrange
        ComandoAlquiler alquiler = new ComandoAlquilerTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/gestionar-alquiler/usuario/monto?cedula=1098682980&fechaYHoraEntrega=2021-03-31T09:30:00")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("50000.0")); // calculo monto;
    }

}

