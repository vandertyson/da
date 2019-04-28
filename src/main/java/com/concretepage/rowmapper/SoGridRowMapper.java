package com.concretepage.rowmapper;

import com.concretepage.entity.SoGrid;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SoGridRowMapper implements RowMapper<SoGrid> {

    @Override
    public SoGrid mapRow(ResultSet row, int rowNum) throws SQLException {
        SoGrid grid = new SoGrid();

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
