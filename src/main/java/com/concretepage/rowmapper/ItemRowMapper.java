package com.concretepage.rowmapper;

import com.concretepage.entity.Item;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper<Item> {
    
    @Override
    public Item mapRow(ResultSet row, int rowNum) throws SQLException {
        Item item = new Item();
        //ten cot luc select ra
        item.setCode(row.getString("ItemCode"));
        item.setName(row.getString("ItemName"));
        item.setGroup(row.getInt("ItmsGrpCod"));
        item.setVatGroup(row.getString("VatGourpSa"));
        item.setOnhand(row.getDouble("OnHand"));
        return item;
    }
    
}
