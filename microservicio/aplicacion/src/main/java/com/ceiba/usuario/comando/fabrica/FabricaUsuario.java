package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.dtoComando.ComandoUsuario;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;


@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) { // viene del front end
        return new Usuario(
                comandoUsuario.getCedula(),
                comandoUsuario.getNombre(),
                comandoUsuario.getFechaNacido()
        );
    }

    public Usuario crear(DtoUsuario dtoUsuario) { // viene de base de datos
        return new Usuario(
                dtoUsuario.getCedula(),
                dtoUsuario.getNombre(),
                dtoUsuario.getFechaNacido()
        );
    }
}
