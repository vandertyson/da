package com.concretepage.rowmapper;

import com.concretepage.entity.ArInvoice;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArInvoiceRowMapper implements RowMapper<ArInvoice> {

    @Override
    public ArInvoice mapRow(ResultSet row, int rowNum) throws SQLException {
        ArInvoice head = new ArInvoice();

        head.setId(row.getInt("DocEntry"));
        head.setDocnum(row.getInt("DocNum"));
        head.setCode(row.getString("CardCode"));
        head.setName(row.getString("CardName"));
        head.setContactCode(row.getString("CntctCode"));
        head.setCurrency(row.getString("DocCur"));
        head.setSaleEmployee(row.getString("SlpCode"));
        head.setEmployee(row.getString("OwnerCode"));
        head.setAddress(row.getString("Address2"));
        head.setShipto(row.getString("ShipToCode"));
        head.setTrasnport(row.getInt("TrnspCode"));
        head.setDocDate(row.getDate("DocDate"));
        head.setDueDate(row.getDate("DocDueDate"));
        head.setTaxDate(row.getDate("TaxDate"));
        head.setContactName(row.getString("Name"));
        head.setSlpname(row.getString("SlpName"));
        head.setEmfirstname(row.getString("FirstName"));
        head.setEmplastname(row.getString("LastName"));
        head.setTransportname(row.getString("TrnspName"));
        head.setRef(row.getString("Ref1"));

        return head;
    }

}
