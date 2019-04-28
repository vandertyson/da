package com.concretepage.rowmapper;

import com.concretepage.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {
    
    @Override
    public Customer mapRow(ResultSet row, int rowNum) throws SQLException {
        Customer cust = new Customer();
        //ten cot luc select ra
        cust.setCode(row.getString("CardCode"));
        cust.setName(row.getString("CardName"));
        cust.setContactperson(row.getString("CntctPrsn"));
        cust.setEmail(row.getString("MailAddres"));
        cust.setFax(row.getString("Fax"));
        cust.setPhone1(row.getString("Phone1"));
        cust.setPhone2(row.getString("Phone2"));
        cust.setSlpcode(row.getInt("SlpCode"));
        cust.setCreatedate(row.getDate("CreateDate"));
        cust.setUpdatedate(row.getDate("UpdateDate"));
        cust.setUsersign(row.getInt("UserSign"));
        return cust;
    }
    
}
