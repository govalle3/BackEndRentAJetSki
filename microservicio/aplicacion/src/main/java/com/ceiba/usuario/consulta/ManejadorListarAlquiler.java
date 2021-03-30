package com.ceiba.usuario.consulta;

import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarAlquiler {

    private final DaoAlquiler daoAlquiler;

    public ManejadorListarAlquiler(DaoAlquiler daoAlquiler){
        this.daoAlquiler = daoAlquiler;
    }

    public List<DtoAlquiler> ejecutar(){
        return this.daoAlquiler.listar();
    }
}
