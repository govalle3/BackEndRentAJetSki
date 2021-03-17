package com.ceiba.usuario.adaptador.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import org.springframework.jdbc.core.RowMapper;

public class MapeoAlquiler implements RowMapper<DtoAlquiler>, MapperResult {

    @Override
    public DtoAlquiler mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long nationalId = resultSet.getLong("nationalId");
        String name = resultSet.getString("name");
        LocalDateTime dob = extraerLocalDateTime(resultSet, "dob");
        String idJetSki = resultSet.getString("idJetSki");
        Integer rentTime = resultSet.getInt("rentTime");
        LocalDateTime dateAndTimeRent = extraerLocalDateTime(resultSet, "dateAndTimeRent");
        return new DtoAlquiler(nationalId,name,dob,idJetSki,rentTime,dateAndTimeRent);
    }

}
