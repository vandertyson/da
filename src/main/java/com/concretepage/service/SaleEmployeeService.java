package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.SaleEmployee;
import com.concretepage.daointerface.ISaleEmployeeDAO;

@Service
public class SaleEmployeeService {

    @Autowired
    private ISaleEmployeeDAO DAO;

    public List<SaleEmployee> getAllSaleEmployees() {
        return DAO.getAllSaleEmployees();
    }

    public SaleEmployee getSaleEmployeeById(int empID) {
        return DAO.getSaleEmployeeById(empID);
    }

    public boolean addSaleEmployee(SaleEmployee semp) {
        DAO.addSaleEmployee(semp);
        return true;
    }

}
