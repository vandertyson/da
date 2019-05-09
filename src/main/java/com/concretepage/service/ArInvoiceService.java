package com.concretepage.service;

import com.concretepage.dao.ArInvoiceDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.ArInvoice;
import com.concretepage.daointerface.IArInvoiceDAO;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.IArInvoiceService;

@Service
public class ArInvoiceService implements IArInvoiceService {

    @Autowired
    private ArInvoiceDAO DAO;

    @Override
    public List<ArInvoice> getAllInvoices() {
        return DAO.getAllInvoices();
    }

    @Override
    public ArInvoice getInvoiceById(int invID) {
        return DAO.getInvoiceById(invID);
    }

    @Override
    public Long getNewInvoiceID() {
        return DAO.getInvoiceById();

    }

    @Override
    public void addnewInvoice(ArInvoice inv) {
        DAO.addnewInvoice(inv);
    }

    @Override
    public List<Transport> getAllTransports() {
        return DAO.getAllTransports();
    }

    @Override
    public void updateInvoice(ArInvoice inv) {
        DAO.updateInvoice(inv);
    }

    @Override
    public void deleteInvoice(Integer id) {
        DAO.deleteInvoice(id);
    }

}
