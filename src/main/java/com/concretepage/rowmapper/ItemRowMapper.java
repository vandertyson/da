package com.concretepage.rowmapper;

import com.concretepage.entity.Item;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet row, int rowNum) throws SQLException {
        Item item = new Item();
        item.setCode(row.getString("ItemCode"));
        item.setName(row.getString("ItemName"));
        item.setGroup(row.getInt("ItmsGrpCod"));
        item.setOnhand(row.getDouble("OnHand"));
        item.setUomcode(row.getString("InvntryUom"));
        item.setGroupname(row.getString("ItmsGrpNam"));
        item.setVat(row.getInt("vat"));
        return item;
    }

}
