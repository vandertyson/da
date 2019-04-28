package com.concretepage.service;

import com.concretepage.iservice.IItemService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.daointerface.IItemDAO;
import com.concretepage.entity.Item;

@Service
public class ItemService implements IItemService {

    @Autowired
    private IItemDAO DAO;

    @Override
    public List<Item> getAllItem() {
        return DAO.getAllItem();
    }

    @Override
    public boolean addItem(Item item) {
        DAO.addItem(item);
        return true;
    }

    @Override
    public List<Item> findItemByName(String name) {
        return DAO.getItemWithName(name);
    }

    @Override
    public List<Item> getAllItem(String top) {
        return DAO.getAllItem(top);
    }

    @Override
    public boolean updateItem(Item item) {
        DAO.updateItem(item);
        return true;
    }

    @Override
    public boolean deleteItem(String code) {
        DAO.deleteItem(code);
        return true;
    }

    @Override
    public Item getItemById(String code) {
        return DAO.getItemById(code);
    }

}
