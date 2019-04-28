package com.concretepage.iservice;

import com.concretepage.entity.Customer;
import java.util.List;

import com.concretepage.entity.Employee;

public interface IEmployeeService {

    List<Employee> getAllEmployees();
    //Article getArticleById(int articleId);

    boolean addEmployee(Employee emp);
    
    void updateEmployee(Employee emp);
    
    boolean deleteEmployee(int empID);
    
    public List<Employee> findEmployeeByName(String name);

    public Employee getEmployeeById(int empID);

}
