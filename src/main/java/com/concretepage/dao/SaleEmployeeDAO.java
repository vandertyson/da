package com.concretepage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.SaleEmployee;
import com.concretepage.rowmapper.SaleEmployeeRowMapper;
import com.concretepage.daointerface.ISaleEmployeeDAO;

@Transactional
@Repository
public class SaleEmployeeDAO implements ISaleEmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SaleEmployee> getAllSaleEmployees() {
        String sql = "SELECT SlpCode,SlpName from dbo.OSLP";
        RowMapper<SaleEmployee> rowMapper = new SaleEmployeeRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public SaleEmployee getSaleEmployeeById(int empID) {
        String sql = "SELECT SlpCode,SlpName from dbo.OSLP";
        RowMapper<SaleEmployee> rowMapper = new SaleEmployeeRowMapper();
        SaleEmployee emp = jdbcTemplate.queryForObject(sql, rowMapper, empID);
        return emp;
    }

    @Override
    public void addSaleEmployee(SaleEmployee semp) {
        String sql = "INSERT INTO dbo.OSLP (SlpCode,SlpName) values (?,?)";
        jdbcTemplate.update(sql, semp.getCode(), semp.getName());
    }

}
