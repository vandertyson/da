package com.concretepage.rowmapper;

import com.concretepage.entity.SalesQuotation;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SalesQuotationRowMapper implements RowMapper<SalesQuotation> {

    @Override
    public SalesQuotation mapRow(ResultSet row, int rowNum) throws SQLException {
        SalesQuotation head = new SalesQuotation();
        //ten cot luc select ra
        head.setId(row.getInt("DocEntry"));
        head.setDocnum(row.getInt("DocNum"));
        head.setCode(row.getString("CardCode"));
        head.setName(row.getString("CardName"));
        head.setContactCode(row.getString("CntctCode"));
        head.setContactName(row.getString("Name"));
        head.setCurrency(row.getString("DocCur"));
        head.setSaleEmployee(row.getString("SlpCode"));
        head.setEmployee(row.getString("OwnerCode"));
        head.setDocDate(row.getDate("DocDate"));
        head.setDueDate(row.getDate("DocDueDate"));
        head.setTaxDate(row.getDate("TaxDate"));
        head.setSlpname(row.getString("SlpName"));
        head.setEmfirstname(row.getString("FirstName"));
        head.setEmplastname(row.getString("LastName"));
        head.setDocstatus(row.getString("DocStatus"));
        head.setRef(row.getString("Ref1"));
        return head;
    }

}
