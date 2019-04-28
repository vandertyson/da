package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.DeliveryGrid;
import com.concretepage.iservice.IDeliveryGridService;

@Controller
@RequestMapping("argrid")
public class ArGridController {

    @Autowired
    private IDeliveryGridService service;

    @GetMapping("grid/{id}")
    public ResponseEntity<DeliveryGrid> getSoGridById(@PathVariable("id") Integer id) {
        DeliveryGrid grid = service.getDeliveryGridById(id);
        return new ResponseEntity<DeliveryGrid>(grid, HttpStatus.OK);
    }

    @GetMapping("deliverygrids")
    public ResponseEntity<List<DeliveryGrid>> getAllDeliveryGrids() {
        List<DeliveryGrid> list = service.getAllDeliveryGrids();
        return new ResponseEntity<List<DeliveryGrid>>(list, HttpStatus.OK);
    }
}
