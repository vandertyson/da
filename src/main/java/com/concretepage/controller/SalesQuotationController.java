package com.concretepage.controller;

import com.concretepage.entity.ContactPerson;
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
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.ISalesQuotationService;
import com.concretepage.service.EmployeeService;
import com.concretepage.service.SaleEmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("quotation")
public class SalesQuotationController {

    @Autowired
    private ISalesQuotationService service;

    @Autowired
    private SaleEmployeeService saleemployeeService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("quotation/{id}")
    public ResponseEntity<SalesQuotation> getQuotationById(@PathVariable("id") Integer id) {
        SalesQuotation quot = service.getQuotationById(id);
        return new ResponseEntity<SalesQuotation>(quot, HttpStatus.OK);
    }

    @GetMapping("quotations")
    public ResponseEntity<List<SalesQuotation>> getAllQuotations() {
        List<SalesQuotation> list = service.getAllQuotation();
        return new ResponseEntity<List<SalesQuotation>>(list, HttpStatus.OK);
    }

    @GetMapping("newid")
    public ResponseEntity<Long> getNewIDQuotation() {
        Long newQuottionID = service.getNewQuottionID();
        return new ResponseEntity<Long>(newQuottionID, HttpStatus.OK);
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

    @PostMapping("addquotation")
    public ResponseEntity<Boolean> addQuotation(@RequestBody SalesQuotation quot, UriComponentsBuilder builder) {

        service.addnewQuotation(quot);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @GetMapping("transport")
    public ResponseEntity<List<Transport>> getAllTransports() {
        List<Transport> list = service.getAllTransports();
        return new ResponseEntity<List<Transport>>(list, HttpStatus.OK);
    }

    @GetMapping("contacts")
    public ResponseEntity<List<ContactPerson>> getAllContacts() {
        List<ContactPerson> list = service.getAllContacts();
        return new ResponseEntity<List<ContactPerson>>(list, HttpStatus.OK);
    }

    @PutMapping("updatequotation")
    public ResponseEntity<SalesQuotation> updateQuotation(@RequestBody SalesQuotation qot) {
        service.updateQuotation(qot);
        return new ResponseEntity<SalesQuotation>(qot, HttpStatus.OK);
    }

    @DeleteMapping("deleteQuotation/{id}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable("id") Integer id) {
        service.deleteQuotation(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
