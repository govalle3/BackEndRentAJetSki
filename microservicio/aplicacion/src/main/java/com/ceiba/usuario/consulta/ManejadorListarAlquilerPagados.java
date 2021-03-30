package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarAlquilerPagados {

    private final DaoAlquiler daoAlquiler;

    public ManejadorListarAlquilerPagados(DaoAlquiler daoAlquiler){
        this.daoAlquiler = daoAlquiler;
    }

    public List<DtoAlquiler> ejecutar(){
        return this.daoAlquiler.listarPagados();
    }
}
