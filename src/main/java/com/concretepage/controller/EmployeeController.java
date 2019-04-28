package com.concretepage.controller;

import com.concretepage.entity.Customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Employee;
import com.concretepage.iservice.IEmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(value = "name", required = false) String name) {
        if (name != null && !name.isEmpty()) {
            List<Employee> list = service.findEmployeeByName(name);
            return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
        }
        List<Employee> list = service.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @PostMapping("addEmployee")
    public ResponseEntity<Boolean> addEmployee(@RequestBody Employee emp, UriComponentsBuilder builder) {
        System.out.println(emp);
        service.addEmployee(emp);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @PutMapping("updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        service.updateEmployee(emp);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @DeleteMapping("deleteEmployee/{empID}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("empID") Integer empID) {
        service.deleteEmployee(empID);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empID) {
        Employee emp = service.getEmployeeById(empID);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

}
