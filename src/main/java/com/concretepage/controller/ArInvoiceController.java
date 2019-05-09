package com.concretepage.controller;

import com.concretepage.entity.ArInvoice;
import com.concretepage.entity.Delivery;
import com.concretepage.entity.Employee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.SaleEmployee;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.IArInvoiceService;
import com.concretepage.service.EmployeeService;
import com.concretepage.service.SaleEmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("invoice")
public class ArInvoiceController {

    @Autowired
    private IArInvoiceService service;

    @Autowired
    private SaleEmployeeService saleemployeeService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("invoice/{id}")
    public ResponseEntity<ArInvoice> getInvoiceById(@PathVariable("id") Integer id) {
        ArInvoice inv = service.getInvoiceById(id);
        return new ResponseEntity<ArInvoice>(inv, HttpStatus.OK);
    }

    @GetMapping("invoices")
    public ResponseEntity<List<ArInvoice>> getAllInvoices() {
        List<ArInvoice> list = service.getAllInvoices();
        return new ResponseEntity<List<ArInvoice>>(list, HttpStatus.OK);
    }

    @GetMapping("newid")
    public ResponseEntity<Long> getNewIDInvoice() {
        Long newInvoiceID = service.getNewInvoiceID();
        return new ResponseEntity<Long>(newInvoiceID, HttpStatus.OK);
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

    @PostMapping("addInvoice")
    public ResponseEntity<Boolean> addInvoice(@RequestBody ArInvoice inv, UriComponentsBuilder builder) {

        service.addnewInvoice(inv);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @GetMapping("transport")
    public ResponseEntity<List<Transport>> getAllTransports() {
        List<Transport> list = service.getAllTransports();
        return new ResponseEntity<List<Transport>>(list, HttpStatus.OK);
    }

    @PutMapping("updateInvoice")
    public ResponseEntity<ArInvoice> updateInvoice(@RequestBody ArInvoice inv) {
        service.updateInvoice(inv);
        return new ResponseEntity<ArInvoice>(inv, HttpStatus.OK);
    }

    @DeleteMapping("deleteInvoice/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") Integer id) {
        service.deleteInvoice(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
