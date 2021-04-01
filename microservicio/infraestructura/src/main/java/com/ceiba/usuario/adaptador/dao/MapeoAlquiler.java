package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoAlquiler implements RowMapper<DtoAlquiler>, MapperResult {

    @Override
    public DtoAlquiler mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long cedula = resultSet.getLong("cedula");
        String idJetSki = resultSet.getString("idJetSki");
        Integer tiempoRenta = resultSet.getInt("tiempoRenta");
        LocalDateTime fechaYHoraRenta = extraerLocalDateTime(resultSet, "fechaYHoraRenta");
        return new DtoAlquiler(cedula,idJetSki,tiempoRenta,fechaYHoraRenta);
    }

}
