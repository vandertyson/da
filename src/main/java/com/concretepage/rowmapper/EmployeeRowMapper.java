/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.rowmapper;

import com.concretepage.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Admin
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
        Employee emp = new Employee();
        emp.setId(row.getInt("empID"));
        emp.setFirstname(row.getString("firstName"));
        emp.setLastname(row.getString("lastName"));
        emp.setDept(row.getInt("dept"));
        return emp;
    }
}
