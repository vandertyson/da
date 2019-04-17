package com.concretepage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Employee;
import com.concretepage.rowmapper.EmployeeRowMapper;
import com.concretepage.daointerface.IEmployeeDAO;

@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * from view_employee";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Employee getEmployeeById(int empID) {
        String sql = "SELECT * from view_employee";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, empID);
        return emp;
    }

    @Override
    public void addEmployee(Employee emp) {
        //add employee
        String sql = "INSERT INTO dbo.OHEM (empID,firstName,lastName,sex,dept,userId) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, emp.getId(), emp.getFirstname(), emp.getLastname(), emp.getSex(), emp.getDept(), emp.getUserid());
    }

    @Override
    public List<Employee> getEmployeeWithName(String name) {
        String sql = "SELECT empID,firstName,lastName,sex,dept,userId FROM dbo.OHEM where empID = ? ";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.query(sql, new Object[]{name}, rowMapper);
    }

    @Override
    public void updateEmployee(Employee emp) {
        String sql = "UPDATE dbo.OHEM SET firstName =?, lastName=?,dept=?,sex=? WHERE empID=?";
        jdbcTemplate.update(sql, emp.getFirstname(), emp.getLastname(), emp.getDept(), emp.getId());
    }

    @Override
    public void deleteEmployee(int empID) {
        String sql = "DELETE FROM dbo.OHEM where empID = ?";
        jdbcTemplate.update(sql, empID);
    }

}
