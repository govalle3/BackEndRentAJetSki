package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarAlquilerPorPagar {

    private final DaoAlquiler daoAlquiler;

    public ManejadorListarAlquilerPorPagar(DaoAlquiler daoAlquiler){
        this.daoAlquiler = daoAlquiler;
    }

    public List<DtoAlquiler> ejecutar(){
        return this.daoAlquiler.listarPorPagar();
    }
}
