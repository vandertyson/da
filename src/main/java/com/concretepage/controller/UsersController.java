package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.concretepage.entity.Item;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Users;
import com.concretepage.iservice.IItemService;
import com.concretepage.iservice.IUsersService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("user")
public class UsersController {

    @Autowired
    private IUsersService service;

    @GetMapping("user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") int id) {
        Users user = service.getUserById(id);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }

}
