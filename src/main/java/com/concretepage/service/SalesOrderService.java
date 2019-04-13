package com.concretepage.service;

import com.concretepage.dao.SalesOrderDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.ISalesOrderService;

@Service
public class SalesOrderService implements ISalesOrderService {

    @Autowired
    private SalesOrderDAO DAO;

    @Override
    public List<SalesOrder> getAllOrder() {
        return DAO.getAllOrder();
    }

    @Override
    public SalesOrder getOrderById(int ordID) {
        return DAO.getOrderById(ordID);
    }

    @Override
    public Long getNewOrderID() {
        return DAO.getOrderById();
    }

    @Override
    public void addnewOrder(SalesOrder ord) {
        DAO.addnewOrder(ord);
    }

    @Override
    public List<Transport> getAllTransports() {
        return DAO.getAllTransports();
    }

    @Override
    public void deleteOrder(int id) {
        DAO.deleteOrder(id);
    }

    @Override
    public void updateOrder(SalesOrder ord) {
        DAO.updateOrder(ord);
    }

    @Override
    public List<SalesQuotation> getListQuotation() {
        return DAO.getListQuotation();
    }

    @Override
    public void copyQuotation(SalesQuotation quot) {
        DAO.copyQuotation(quot);
    }

}
