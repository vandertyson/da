/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.service;

import com.concretepage.daointerface.IItemDAO;
import com.concretepage.daointerface.IUsersDAO;
import com.concretepage.entity.Item;
import com.concretepage.entity.Users;
import com.concretepage.iservice.IItemService;
import com.concretepage.iservice.IUsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UsersService implements IUsersService {
     @Autowired
    private IUsersDAO DAO;

    @Override
    public List<Users> getAllUsers() {
        return DAO.getAllUsers();
    }

    @Override
    public boolean addUser(Users user) {
        DAO.addUser(user);
        return true;
    }

    @Override
    public boolean updateUser(Users user) {
        DAO.addUser(user);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        DAO.deleteUser(id);
        return true;
    }

    @Override
    public Users getUserById(int id) {
        return DAO.getUserById(id);
    }

   
}
