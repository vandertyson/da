package com.concretepage.controller;

import com.concretepage.entity.InPayment;
import com.concretepage.iservice.IInPaymentService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("payment")
public class InPaymentController {
    
    @Autowired
    private IInPaymentService service;

    @GetMapping("payment/{id}")
    public ResponseEntity<InPayment> getPaymentById(@PathVariable("id") Integer id) {
        InPayment pay = service.getPaymentById(id);
        return new ResponseEntity<InPayment>(pay, HttpStatus.OK);
    }

    @GetMapping("payments")
    public ResponseEntity<List<InPayment>> getAllPayment() {
            List<InPayment> list = service.getAllPayment();
            return new ResponseEntity<List<InPayment>>(list, HttpStatus.OK);

    }
    
    @PostMapping("addPayment")
    public ResponseEntity<Boolean> addPayment(@RequestBody InPayment pay, UriComponentsBuilder builder) {
        service.addPayment(pay);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
    
    @PutMapping("updatePayment")
    public ResponseEntity<Boolean> updatePayment(@RequestBody InPayment pay) {
        service.updatePayment(pay);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @DeleteMapping("deletePayment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable("id") Integer id) {
        service.deletePayment(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
