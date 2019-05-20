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
import com.concretepage.entity.Stat;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.ISalesQuotationService;
import com.concretepage.service.EmployeeService;
import com.concretepage.service.SaleEmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<SalesQuotation>> getAllQuotations(@RequestParam(value = "status", required = false) String status) {
        if (status == null) {
            List<SalesQuotation> list = service.getAllQuotation();
            return new ResponseEntity<List<SalesQuotation>>(list, HttpStatus.OK);
        } else {
            List<SalesQuotation> list = service.getAllQuotation(status);
            return new ResponseEntity<List<SalesQuotation>>(list, HttpStatus.OK);
        }
    }

    @GetMapping("newid")
    public ResponseEntity<Long> getNewIDQuotation() {
        Long newQuottionID = service.getNewQuottionID();
        return new ResponseEntity<Long>(newQuottionID, HttpStatus.OK);
    }

    @GetMapping("saleEmployee")
    public ResponseEntity<List<SaleEmployee>> getAllSaleEmployees() {
        List<SaleEmployee> list = saleemployeeService.getAllSaleEmployees();
        return new ResponseEntity<List<SaleEmployee>>(list, HttpStatus.OK);
    }

    @GetMapping("employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @PostMapping("addQuotation")
    public ResponseEntity<Boolean> addnewQuotation(@RequestBody SalesQuotation quot, UriComponentsBuilder builder) {

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

    @PutMapping("updateQuotation")
    public ResponseEntity<Boolean> updateQuotation(@RequestBody SalesQuotation qot) {
        service.updateQuotation(qot);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @DeleteMapping("deleteQuotation/{id}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable("id") Integer id) {
        service.deleteQuotation(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("confirm")
    public ResponseEntity<Boolean> confirm(@RequestParam("id") Integer quot_id, @RequestParam("confirm") String stat) {
        if (service.confirmQuotation(quot_id, stat)) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
    }

    @GetMapping("count")
    public ResponseEntity<List<Stat>> countQuot() {        
        return new ResponseEntity<List<Stat>>(service.countQuot(), HttpStatus.OK);
    }

    @GetMapping("listQuot")
    public ResponseEntity<List<SalesQuotation>> getQuotByCustomer(@RequestParam("code") String code) {
        List<SalesQuotation> list = service.getQuotByCustomer(code);
        return new ResponseEntity<List<SalesQuotation>>(list, HttpStatus.OK);
    }
}
