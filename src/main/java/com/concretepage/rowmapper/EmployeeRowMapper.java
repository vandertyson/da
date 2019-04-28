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
        emp.setSex(row.getString("sex"));
        emp.setTel(row.getString("officeTel"));
        emp.setEmail(row.getString("email"));
        emp.setJobtitle(row.getString("jobTitle"));
        emp.setHomecity(row.getString("homeCity"));
        emp.setUpdatedate(row.getDate("UpdateDate"));
        emp.setStartdate(row.getDate("startDate"));
        emp.setDeptname(row.getString("Name"));
        emp.setUsersign(row.getInt("UserSign"));
        emp.setBirthdate(row.getDate("birthDate"));
        emp.setBankcode(row.getString("bankCode"));
        emp.setBankacount(row.getString("bankAcount"));
        return emp;
    }
}
