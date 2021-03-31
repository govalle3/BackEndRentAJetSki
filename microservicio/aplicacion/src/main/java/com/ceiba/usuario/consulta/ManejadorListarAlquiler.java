package com.ceiba.usuario.consulta;

import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarAlquiler {

    private final DaoRentAJetSki daoRentAJetSki;

    public ManejadorListarAlquiler(DaoRentAJetSki daoRentAJetSki){
        this.daoRentAJetSki = daoRentAJetSki;
    }

    public List<DtoAlquiler> ejecutar(){
        return this.daoRentAJetSki.listar();
    }
}
