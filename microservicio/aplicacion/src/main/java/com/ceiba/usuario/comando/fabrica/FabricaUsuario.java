package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.dtoComando.ComandoUsuarioAlquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;


@Component
public class FabricaUsuario {

    public Usuario crearUsuario(ComandoUsuarioAlquiler comandoUsuarioAlquiler) { // viene del front end
        return new Usuario(
                comandoUsuarioAlquiler.getCedula(),
                comandoUsuarioAlquiler.getNombre(),
                comandoUsuarioAlquiler.getFechaNacido()
        );
    }
}
