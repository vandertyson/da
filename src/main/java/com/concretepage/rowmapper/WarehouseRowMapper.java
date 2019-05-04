package com.concretepage.rowmapper;

import com.concretepage.entity.Warehouse;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WarehouseRowMapper implements RowMapper<Warehouse> {
    
    @Override
    public Warehouse mapRow(ResultSet row, int rowNum) throws SQLException {
        Warehouse whs = new Warehouse();
        whs.setWhscode(row.getString("WhsCode"));
        whs.setWhsname(row.getString("WhsName"));
        whs.setLock(row.getString("Locked"));
        whs.setObjtype(row.getString("objType"));
        whs.setCreatedate(row.getDate("createDate"));
        return whs;
    }
    
}
