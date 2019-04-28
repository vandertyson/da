/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.dao;

import com.concretepage.daointerface.IUsersDAO;
import com.concretepage.daointerface.IUsersDAO;
import com.concretepage.entity.Item;
import com.concretepage.entity.Users;
import com.concretepage.rowmapper.ItemRowMapper;
import com.concretepage.rowmapper.UsersRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Transactional
@Repository
public class UsersDAO implements IUsersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
   

    @Override
    public List<Users> getAllUsers() {
        String sql = "SELECT * FROM dbo.OUSR";
        RowMapper<Users> rowMapper = new UsersRowMapper();

        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void addUser(Users user) {
         String sql = "INSERT INTO dbo.OUSR (USERID,PASSWORD) values (?,?)";
        jdbcTemplate.update(sql, user.getId(),user.getPassword());
    }

    @Override
    public void updateUser(Users user) {
        String sql = "UPDATE dbo.OUSR SET (PASSWORD)"
                + "WHERE USERID = ?";
        jdbcTemplate.update(sql, user.getPassword(),user.getId());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM dbo.OUSR where USERID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Users getUserById(int id) {
         String sql = "select * from dbo.OUSR where USERID = ?";
        RowMapper<Users> rowMapper = new UsersRowMapper();
        Users user = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return user;
    }
}
