package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.Item;
import com.concretepage.iservice.IItemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    private IItemService service;

    @GetMapping("items")
    public ResponseEntity<List<Item>> getItems(@RequestParam(value = "top",
            required = false) String top, @RequestParam(value = "name", required = false) String name) {
        //Item item = service.getItemById(id);
        //return new ResponseEntity<Item>(item, HttpStatus.OK);
        if (top != null && !top.isEmpty()) {
            List<Item> list = service.getAllItem(top);
            return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
        }
        if (name != null && !name.isEmpty()) {
            List<Item> list = service.findItemByName(name);
            return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
        }
        List<Item> list = service.getAllItem();
        return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }

    @PostMapping("addnewItem")
    public ResponseEntity<Boolean> addItem(@RequestBody Item item, UriComponentsBuilder builder) {
        //List<Item> list = service.getAllItem();
        //return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
        System.out.println(item);
        service.addItem(item);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @PutMapping("updateItem")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        service.updateItem(item);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @DeleteMapping("deleteItem/{code}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable("code") String code) {
        service.deleteItem(code);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }

}
