package com.concretepage.rowmapper;

import com.concretepage.entity.SqGrid;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SqGridRowMapper implements RowMapper<SqGrid> {
    
    @Override
    public SqGrid mapRow(ResultSet row, int rowNum) throws SQLException {
        SqGrid grid = new SqGrid();
        //ten cot luc select ra
        grid.setId(row.getInt("DocEntry"));
        grid.setItemcode(row.getString("ItemCode"));
        grid.setDescription(row.getString("Dscription"));
        grid.setCurrency(row.getString("Currency"));
        grid.setQuantity(row.getDouble("Quantity"));
        grid.setPrice(row.getDouble("Price"));
        grid.setVatgroup(row.getString("VatGroup"));
        grid.setTaxcode(row.getString("TaxCode"));
        grid.setTotal(row.getDouble("LineTotal"));
        grid.setUomcode(row.getString("UomCode"));
        grid.setLinenum(row.getInt("LineNum"));
        return grid;
    }
    
}
