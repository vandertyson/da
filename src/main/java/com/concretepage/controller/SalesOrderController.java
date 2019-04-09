package com.concretepage.controller;

import com.concretepage.entity.Employee;
import com.concretepage.entity.SaleEmployee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.ISalesOrderService;
import com.concretepage.service.EmployeeService;
import com.concretepage.service.SaleEmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("salesorder")
public class SalesOrderController {

    @Autowired
    private ISalesOrderService service;

    @Autowired
    private SaleEmployeeService saleemployeeService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("salesorder/{id}")
    public ResponseEntity<SalesOrder> getOrderById(@PathVariable("id") Integer id) {
        SalesOrder ord = service.getOrderById(id);
        return new ResponseEntity<SalesOrder>(ord, HttpStatus.OK);
    }

    @GetMapping("salesorders")
    public ResponseEntity<List<SalesOrder>> getAllOrders() {
        List<SalesOrder> list = service.getAllOrder();
        return new ResponseEntity<List<SalesOrder>>(list, HttpStatus.OK);
    }

    @GetMapping("newid")
    public ResponseEntity<Long> getNewIDOrder() {
        Long newOrderID = service.getNewOrderID();
        return new ResponseEntity<Long>(newOrderID, HttpStatus.OK);
    }

    @GetMapping("saleemployee")
    public ResponseEntity<List<SaleEmployee>> getAllSaleEmployees() {
        List<SaleEmployee> list = saleemployeeService.getAllSaleEmployees();
        return new ResponseEntity<List<SaleEmployee>>(list, HttpStatus.OK);
    }

    @GetMapping("employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @PostMapping("addorder")
    public ResponseEntity<Boolean> addOrder(@RequestBody SalesOrder ord, UriComponentsBuilder builder) {

        service.addnewOrder(ord);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @GetMapping("transport")
    public ResponseEntity<List<Transport>> getAllTransports() {
        List<Transport> list = service.getAllTransports();
        return new ResponseEntity<List<Transport>>(list, HttpStatus.OK);
    }

    @PutMapping("updateorder")
    public ResponseEntity<SalesOrder> updateOrder(@RequestBody SalesOrder ord) {
        service.updateOrder(ord);
        return new ResponseEntity<SalesOrder>(ord, HttpStatus.OK);
    }

    @DeleteMapping("deleteOrder/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id) {
        service.deleteOrder(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
