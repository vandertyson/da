package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Customer;
import com.concretepage.iservice.ICustomerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(value = "top", required = false) String top, @RequestParam(value = "name", required = false) String name) {
        if (top != null && !top.isEmpty()) {
            List<Customer> list = service.getAllCustomer(top);
            return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
        }
        if (name != null && !name.isEmpty()) {
            List<Customer> list = service.findCustomerByName(name);
            return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
        }
        List<Customer> list = service.getAllCustomer();
        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @PostMapping("addCustomer")
    public ResponseEntity<Boolean> addCustomer(@RequestBody Customer cust, UriComponentsBuilder builder) {
        System.out.println(cust);
        service.addCustomer(cust);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @PutMapping("updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust) {
        service.updateCustomer(cust);
        return new ResponseEntity<Customer>(cust, HttpStatus.OK);
    }

    @DeleteMapping("deleteCustomer/{code}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("code") String code) {
        service.deleteCustomer(code);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }

}
