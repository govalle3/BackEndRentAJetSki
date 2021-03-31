package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarAlquilerPorPagar {

    private final DaoRentAJetSki daoRentAJetSki;

    public ManejadorListarAlquilerPorPagar(DaoRentAJetSki daoRentAJetSki){
        this.daoRentAJetSki = daoRentAJetSki;
    }

    public List<DtoAlquiler> ejecutar(){
        return this.daoRentAJetSki.listarPorPagar();
    }
}
