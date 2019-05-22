/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.rowmapper;

import com.concretepage.entity.InPayment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Admin
 */
public class InPaymentRowMapper implements RowMapper<InPayment> {

    @Override
    public InPayment mapRow(ResultSet row, int rowNum) throws SQLException {
        InPayment head = new InPayment();
        head.setBankacc(row.getString("BankAcct"));
        head.setBankcode(row.getString("BankCode"));
        head.setCode(row.getString("CardCode"));
        head.setName(row.getString("CardName"));
        head.setContactCode(row.getString("CntctCode"));
        head.setContactName(row.getString("Name"));
        head.setDocentry(row.getInt("DocEntry"));
        head.setDocnum(row.getInt("DocNum"));
        head.setDocdate(row.getDate("DocDate"));
        head.setDuedate(row.getDate("DocDueDate"));
        head.setTaxdate(row.getDate("TaxDate"));
        head.setDoctype(row.getString("DocType"));
        head.setDoctotal(row.getDouble("DocTotal"));
        return head;
    }

}
