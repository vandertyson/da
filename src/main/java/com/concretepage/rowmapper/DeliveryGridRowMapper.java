package com.concretepage.rowmapper;

import com.concretepage.entity.DeliveryGrid;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeliveryGridRowMapper implements RowMapper<DeliveryGrid> {

    @Override
    public DeliveryGrid mapRow(ResultSet row, int rowNum) throws SQLException {
        DeliveryGrid grid = new DeliveryGrid();
        grid.setId(row.getInt("DocEntry"));
        grid.setLinenum(row.getInt("LineNum"));
        grid.setItemcode(row.getString("ItemCode"));
        grid.setDescription(row.getString("Dscription"));
        grid.setCurrency(row.getString("Currency"));
        grid.setQuantity(row.getDouble("Quantity"));
        grid.setPrice(row.getDouble("Price"));
        grid.setVat(row.getInt("vat"));
        grid.setDiscount(row.getInt("DiscPrcnt"));
        grid.setTotal(row.getDouble("LineTotal"));
        grid.setWarehouse(row.getString("WhsCode"));
        grid.setUomcode(row.getString("UomCode"));
        grid.setOpenqty(row.getDouble("OpenQty"));
        return grid;
    }

}
