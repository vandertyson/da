package com.concretepage.rowmapper;

import com.concretepage.entity.SalesOrder;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SalesOrderRowMapper implements RowMapper<SalesOrder> {
    
    @Override
    public SalesOrder mapRow(ResultSet row, int rowNum) throws SQLException {
        SalesOrder head = new SalesOrder();
        //ten cot luc select ra
        head.setId(row.getInt("DocEntry"));
        head.setDocnum(row.getInt("DocNum"));
        head.setCode(row.getString("CardCode"));
        head.setName(row.getString("CardName"));
        head.setContactName(row.getString("CntctCode"));
        head.setCurrency(row.getString("DocCur"));
        head.setSaleEmployee(row.getString("SlpCode"));
        head.setEmployee(row.getString("OwnerCode"));
        head.setAdd(row.getString("Address2"));
        head.setAddress(row.getString("Address"));
        head.setShipto(row.getString("ShipToCode"));
        head.setBillto(row.getString("PayToCode"));
        head.setTrasnport(row.getInt("TrnspCode"));
        head.setSeries(row.getInt("Series"));
        head.setDocDate(row.getDate("DocDate"));
        head.setDueDate(row.getDate("DocDueDate"));
        head.setTaxDate(row.getDate("TaxDate"));
        
        return head;
    }
    
}
