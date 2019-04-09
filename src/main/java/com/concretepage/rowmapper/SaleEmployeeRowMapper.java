/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.rowmapper;

import com.concretepage.entity.SaleEmployee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Admin
 */
public class SaleEmployeeRowMapper implements RowMapper<SaleEmployee> {

    @Override
    public SaleEmployee mapRow(ResultSet row, int rowNum) throws SQLException {
        SaleEmployee emp = new SaleEmployee();
        emp.setName(row.getString("SlpName"));
        emp.setCode(row.getInt("SlpCode"));
        return emp;
    }
}
