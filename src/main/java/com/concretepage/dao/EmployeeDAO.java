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
import com.concretepage.entity.Department;
import com.concretepage.entity.Item;
import com.concretepage.rowmapper.DepartmentRowMapper;
import com.concretepage.rowmapper.ItemRowMapper;

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
        String sql = "SELECT * from view_employee where empID = ?";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, empID);
        return emp;
    }

    @Override
    public void addEmployee(Employee emp) {
        //add employee
        String sql_add = "Select max(empID) from dbo.OHEM";
        Long newEmpId = jdbcTemplate.queryForObject(sql_add, Long.class);
        String sql = "INSERT INTO dbo.OHEM (empID,firstName,lastName,birthDate,sex,dept,officeTel,email,"
                + "jobTitle,homeCity,bankCode,bankAcount,startDate) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, newEmpId + 1, emp.getFirstname(), emp.getLastname(), emp.getBirthdate(),
                emp.getSex(), emp.getDept(), emp.getTel(), emp.getEmail(), emp.getJobtitle(), emp.getHomecity(), emp.getBankcode(),
                emp.getBankacount(), emp.getStartdate());
    }

    @Override
    public List<Employee> getEmployeeWithName(String name) {
        //String sql = "SELECT * FROM view_employee where concat(lastName, ' ', firstName) = ? ";
        String sql = "SELECT * FROM view_employee where firstName like ?";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.query(sql, new String[]{"%" + name + "%"}, rowMapper);
        //RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        //return this.jdbcTemplate.query(sql, new Object[]{name}, rowMapper);
    }

    @Override
    public void updateEmployee(Employee emp) {
        String sql = "UPDATE dbo.OHEM SET firstName =?, lastName=?,birthDate=?,sex=?,dept=?,email=?,"
                + "jobTitle=?,homeCity=?,bankCode=?,bankAcount=?,startDate=? WHERE empID=?";
        jdbcTemplate.update(sql, emp.getFirstname(), emp.getLastname(), emp.getBirthdate(), emp.getSex(),
                emp.getDept(), emp.getEmail(), emp.getJobtitle(), emp.getHomecity(),
                emp.getBankcode(), emp.getBankacount(), emp.getStartdate(), emp.getId());
    }

    @Override
    public void deleteEmployee(int empID) {
        String sql = "DELETE FROM dbo.OHEM where empID = ?";
        jdbcTemplate.update(sql, empID);
    }

    @Override
    public List<Department> getAllDepartments() {
        String sql = "SELECT * from dbo.OUDP";
        RowMapper<Department> rowMapper = new DepartmentRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}
