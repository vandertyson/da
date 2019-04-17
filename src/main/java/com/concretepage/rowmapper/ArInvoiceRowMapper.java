package com.concretepage.rowmapper;

import com.concretepage.entity.ArInvoice;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArInvoiceRowMapper implements RowMapper<ArInvoice> {

    @Override
    public ArInvoice mapRow(ResultSet row, int rowNum) throws SQLException {
        ArInvoice head = new ArInvoice();
        //ten cot luc select ra
        head.setId(row.getInt("DocEntry"));
        head.setCode(row.getString("CardCode"));
        head.setName(row.getString("CardName"));
        head.setEmployee(row.getString("OwnerCode"));
        head.setDocDate(row.getDate("DocDate"));
        head.setDueDate(row.getDate("DocDueDate"));
        head.setTaxDate(row.getDate("TaxDate"));
        head.setAddress(row.getString("Address2"));
        head.setShipto(row.getString("ShipToCode"));
        head.setTrasnport(row.getInt("TrnspCode"));
        return head;
    }

}
