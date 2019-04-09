package com.concretepage.dao;

import com.concretepage.daointerface.ICustomerDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Customer;
import com.concretepage.rowmapper.CustomerRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomer() {
        String sql = "SELECT CardCode,CardName,CntctPrsn,MailAddres,Fax,Phone1,"
                + "Phone2,SlpCode FROM dbo.OCRD ";
        RowMapper<Customer> rowMapper = new CustomerRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Customer> getAllCustomer(String top) {
        String sql = "SELECT TOP (?) CardCode,CardName,CntctPrsn,MailAddres,Fax,"
                + "Phone1,Phone2,SlpCode FROM dbo.OCRD ";
        RowMapper<Customer> rowMapper = new CustomerRowMapper();
        return this.jdbcTemplate.query(sql, new Object[]{Integer.parseInt(top)}, rowMapper);
    }

    @Override
    public void addCustomer(Customer cust) {
        //add customer
        String sql1 = "Select max(DocEntry) from dbo.OCRD";
        Long newid = jdbcTemplate.queryForObject(sql1, Long.class);
        String sql = "INSERT INTO dbo.OCRD (CardCode,CardName,CntctPrsn,MailAddres,"
                + "Fax,Phone1,Phone2,DocEntry) values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, cust.getCode(), cust.getName(), cust.getContactperson(),
                cust.getFax(), cust.getEmail(), cust.getPhone1(), cust.getPhone2(), newid + 1);
    }

    @Override
    public List<Customer> getCustomerWithName(String name) {
        String sql = "SELECT CardCode,CardName,CntctPrsn,MailAddres,Fax,Phone1,"
                + "Phone2,DocEntry FROM dbo.OCRD where CardName = ? ";
        RowMapper<Customer> rowMapper = new CustomerRowMapper();
        return this.jdbcTemplate.query(sql, new Object[]{name}, rowMapper);
    }

    @Override
    public void updateCustomer(Customer cust) {
        String sql = "UPDATE dbo.OCRD SET CardName=?, CntctPrsn=?, MailAddres=?, "
                + "Fax=?, Phone1=?, Phone2=? WHERE CardCode=?";
        jdbcTemplate.update(sql, cust.getName(), cust.getContactperson(), cust.getEmail(),
                cust.getFax(), cust.getPhone1(), cust.getPhone2(), cust.getCode());
    }

    @Override
    public void deleteCustomer(String code) {
        String sql = "DELETE FROM dbo.OCRD where CardCode = ?";
        jdbcTemplate.update(sql, code);
    }
    
    

}
