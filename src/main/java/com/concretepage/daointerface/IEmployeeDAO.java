package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.Employee;

public interface IEmployeeDAO {

    List<Employee> getAllEmployees();

    void addEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void deleteEmployee(int empID);

    Employee getEmployeeById(int empID);

    public List<Employee> getEmployeeWithName(String name);
}
