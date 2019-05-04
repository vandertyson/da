/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.dao;

import com.concretepage.daointerface.IWarehouseDAO;
import com.concretepage.entity.Item;
import com.concretepage.entity.Warehouse;
import com.concretepage.rowmapper.ItemRowMapper;
import com.concretepage.rowmapper.WarehouseRowMapper;
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
public class WarehouseDAO implements IWarehouseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Warehouse> getAllWarehouses() {
        String sql = "SELECT * FROM dbo.OWHS";
        RowMapper<Warehouse> rowMapper = new WarehouseRowMapper();

        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void addWarehouse(Warehouse whs) {
        String sql = "INSERT INTO dbo.OWHS (WhsCode,WhsName,Locked,createDate)"
                + " values (?,?,?,?)";
        jdbcTemplate.update(sql, whs.getWhscode(), whs.getWhsname(), whs.getLock(), whs.getCreatedate());
    }

    @Override
    public void updateWarehouse(Warehouse whs) {
        String sql = "UPDATE dbo.OWHS SET (WhsName)"
                + "WHERE WhsCode = ?";
        jdbcTemplate.update(sql, whs.getWhsname(), whs.getWhscode());
    }

    @Override
    public void deleteWarehouse(String code) {
        String sql = "DELETE FROM dbo.OWHS where WhsCode = ?";
        jdbcTemplate.update(sql, code);
    }

    @Override
    public Warehouse getWarehouseByCode(String code) {
        String sql = "select * from dbo.OWHS where WhsCode = ?";
        RowMapper<Warehouse> rowMapper = new WarehouseRowMapper();
        Warehouse whs = jdbcTemplate.queryForObject(sql, rowMapper, code);
        return whs;
    }

    @Override
    public List<Warehouse> getWarehouseWithName(String name) {
        String sql = "SELECT * FROM dbo.OWHS where WhsName like ?";
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", "%" + name + "%");
        RowMapper<Warehouse> rowMapper = new WarehouseRowMapper();
        return this.jdbcTemplate.query(sql, new String[]{"%" + name + "%"}, rowMapper);
    }

    @Override
    public List<Warehouse> getAllWarehouses(String top) {
        String sql = "SELECT TOP (?) FROM dbo.OWHS ";
        RowMapper<Warehouse> rowMapper = new WarehouseRowMapper();

        return this.jdbcTemplate.query(sql, new Object[]{Integer.parseInt(top)}, rowMapper);
    }

}
