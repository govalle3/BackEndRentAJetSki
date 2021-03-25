package com.ceiba.usuario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.comando.ComandoAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoAlquilerTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAlquiler.class)
public class ComandoControladorAlquilerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoAlquiler alquiler = new ComandoAlquilerTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/crear")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(alquiler)));
        System.out.println();

    }

    @Test
    public void pagar() throws Exception{
        // arrange
        ComandoAlquiler alquiler = new ComandoAlquilerTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/pagar")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(alquiler)));
    }

}
