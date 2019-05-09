package com.concretepage.controller;

import com.concretepage.entity.Customer;
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
import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.IDeliveryService;
import com.concretepage.iservice.IEmployeeService;
import com.concretepage.iservice.ISalesQuotationService;
import com.concretepage.service.EmployeeService;
import com.concretepage.service.SaleEmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("delivery")
public class DeliveryController {

    @Autowired
    private IDeliveryService service;

    @Autowired
    private SaleEmployeeService saleemployeeService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("delivery/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") Integer id) {
        Delivery delv = service.getDeliveryById(id);
        return new ResponseEntity<Delivery>(delv, HttpStatus.OK);
    }

    @GetMapping("deliveries")
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> list = service.getAllDeliveries();
        return new ResponseEntity<List<Delivery>>(list, HttpStatus.OK);
    }

    @GetMapping("newid")
    public ResponseEntity<Long> getNewIDDelivery() {
        Long newDeliveryID = service.getNewDeliveryID();
        return new ResponseEntity<Long>(newDeliveryID, HttpStatus.OK);
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

    @PostMapping("addDelivery")
    public ResponseEntity<Boolean> addDelivery(@RequestBody Delivery delv, UriComponentsBuilder builder) {

        service.addnewDelivery(delv);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @GetMapping("transport")
    public ResponseEntity<List<Transport>> getAllTransports() {
        List<Transport> list = service.getAllTransports();
        return new ResponseEntity<List<Transport>>(list, HttpStatus.OK);
    }

    @PutMapping("updateDelivery")
    public ResponseEntity<Delivery> updateDelivery(@RequestBody Delivery delv) {
        service.updateDelivery(delv);
        return new ResponseEntity<Delivery>(delv, HttpStatus.OK);
    }

    @DeleteMapping("deleteDelivery/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable("id") Integer id) {
        service.deleteDelivery(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
