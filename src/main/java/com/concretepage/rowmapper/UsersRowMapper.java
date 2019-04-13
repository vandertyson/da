package com.concretepage.rowmapper;

import com.concretepage.entity.Users;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users> {
    
    @Override
    public Users mapRow(ResultSet row, int rowNum) throws SQLException {
        Users usr = new Users();
        usr.setId(row.getInt("USERID"));
        usr.setPassword(row.getString("PASSWORD"));
        return usr;
    }
    
}
