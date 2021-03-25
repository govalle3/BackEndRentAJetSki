package com.ceiba.usuario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoAlquilerTestDataBuilder;
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
    public void crear() throws Exception{
        // arrange
        ComandoAlquiler alquiler = new ComandoAlquilerTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/alquiler/crear")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(alquiler)))
                .andExpect(status().isOk());

    }

    @Test
    public void pagar() throws Exception{
        // arrange
        ComandoAlquiler alquiler = new ComandoAlquilerTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/alquiler/pagar?nationalId=51658659&dateAndTimeCheckout=2021-03-24T13:40:00")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("1550000.0"));
    }

}
