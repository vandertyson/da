package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.Employee;
import com.concretepage.daointerface.IEmployeeDAO;
import com.concretepage.entity.Customer;
import com.concretepage.entity.Department;
import com.concretepage.iservice.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeDAO DAO;

    public List<Employee> getAllEmployees() {
        return DAO.getAllEmployees();
    }

    public Employee getEmployeeById(int empID) {
        return DAO.getEmployeeById(empID);
    }

    @Override
    public boolean addEmployee(Employee emp) {
        DAO.addEmployee(emp);
        return true;
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return DAO.getEmployeeWithName(name);
    }

    @Override
    public void updateEmployee(Employee emp) {
        DAO.updateEmployee(emp);

    }

    @Override
    public boolean deleteEmployee(int empID) {
        DAO.deleteEmployee(empID);
        return true;
    }

    @Override
    public List<Department> getAllDepartments() {
        return DAO.getAllDepartments();
    }

}
