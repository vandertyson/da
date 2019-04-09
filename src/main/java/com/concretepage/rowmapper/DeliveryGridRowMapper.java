package com.concretepage.rowmapper;

import com.concretepage.entity.DeliveryGrid;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeliveryGridRowMapper implements RowMapper<DeliveryGrid> {
    
    @Override
    public DeliveryGrid mapRow(ResultSet row, int rowNum) throws SQLException {
        DeliveryGrid grid = new DeliveryGrid();
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
        grid.setWarehouse(row.getString("WhsCode"));
        grid.setUomcode(row.getString("UomCode"));
        return grid;
    }
    
}
