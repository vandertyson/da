/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.service;

import com.concretepage.daointerface.IWarehouseDAO;
import com.concretepage.entity.Warehouse;
import com.concretepage.iservice.IWarehouseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class WarehouseService implements IWarehouseService {

    @Autowired
    private IWarehouseDAO DAO;

    @Override
    public List<Warehouse> getAllWarehouses() {
        return DAO.getAllWarehouses();
    }

    @Override
    public boolean addWarehouse(Warehouse whs) {
        DAO.addWarehouse(whs);
        return true;
    }

    @Override
    public boolean updateWarehouse(Warehouse whs) {
        DAO.addWarehouse(whs);
        return true;
    }

    @Override
    public boolean deleteWarehouse(String code) {
        DAO.deleteWarehouse(code);
        return true;
    }

    @Override
    public Warehouse getWarehouseByCode(String code) {
        return DAO.getWarehouseByCode(code);
    }

    @Override
    public List<Warehouse> findWarehouseByName(String name) {
        return DAO.getWarehouseWithName(name);
    }

    @Override
    public List<Warehouse> getAllWarehouses(String top) {
       return DAO.getAllWarehouses(top);
    }

}
