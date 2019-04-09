/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.rowmapper;

import com.concretepage.entity.Transport;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Admin
 */
public class TransportRowMapper implements RowMapper<Transport> {

    @Override
    public Transport mapRow(ResultSet row, int rowNum) throws SQLException {
        Transport trans = new Transport();
        trans.setCode(row.getInt("TrnspCode"));
        trans.setName(row.getString("TrnspName"));
        return trans;
    }

}
