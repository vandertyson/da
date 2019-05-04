package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.Item;
import com.concretepage.entity.ItemGroup;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;
import com.concretepage.entity.Warehouse;
import com.concretepage.iservice.IItemService;
import com.concretepage.iservice.IWarehouseService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("warehouse")
public class WarehouseController {

    @Autowired
    private IWarehouseService service;

    @GetMapping("warehouses")
    public ResponseEntity<List<Warehouse>> getWarehouses(@RequestParam(value = "top",
            required = false) String top, @RequestParam(value = "name", required = false) String name) {
        //Item item = service.getItemById(id);
        //return new ResponseEntity<Item>(item, HttpStatus.OK);
        if (top != null && !top.isEmpty()) {
            List<Warehouse> list = service.getAllWarehouses(top);
            return new ResponseEntity<List<Warehouse>>(list, HttpStatus.OK);
        }
        if (name != null && !name.isEmpty()) {
            List<Warehouse> list = service.findWarehouseByName(name);
            return new ResponseEntity<List<Warehouse>>(list, HttpStatus.OK);
        }
        List<Warehouse> list = service.getAllWarehouses();
        return new ResponseEntity<List<Warehouse>>(list, HttpStatus.OK);
    }

    @PostMapping("addWarehouse")
    public ResponseEntity<Boolean> addWarehouse(@RequestBody Warehouse whs, UriComponentsBuilder builder) {
        //List<Item> list = service.getAllItem();
        //return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
        System.out.println(whs);
        service.addWarehouse(whs);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @PutMapping("updateWarehouse")
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse whs) {
        service.updateWarehouse(whs);
        return new ResponseEntity<Warehouse>(whs, HttpStatus.OK);
    }

    @DeleteMapping("deleteWarehouse/{code}")
    public ResponseEntity<Boolean> deleteWarehouse(@PathVariable("code") String code) {
        service.deleteWarehouse(code);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }

    @GetMapping("warehouse/{code}")
    public ResponseEntity<Warehouse> getWarehouseByCode(@PathVariable("code") String code) {
        Warehouse whs = service.getWarehouseByCode(code);
        return new ResponseEntity<Warehouse>(whs, HttpStatus.OK);
    }

}
