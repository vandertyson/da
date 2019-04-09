/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.rowmapper;

import com.concretepage.entity.ContactPerson;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Admin
 */
public class ContactPersonRowMapper implements RowMapper<ContactPerson> {

    @Override
    public ContactPerson mapRow(ResultSet row, int rowNum) throws SQLException {
        ContactPerson contact = new ContactPerson();
        contact.setCode(row.getInt("CntctCode"));
        contact.setName(row.getString("Name"));
        contact.setPosition(row.getString("Position"));
        contact.setPhone(row.getString("Tel1"));
        contact.setEmail(row.getString("E_MailL"));
        return contact;
    }

}
