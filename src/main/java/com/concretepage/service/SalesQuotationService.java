package com.concretepage.service;

import com.concretepage.dao.SalesQuotationDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.SalesQuotation;
import com.concretepage.daointerface.ISalesQuotationDAO;
import com.concretepage.entity.ContactPerson;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.ISalesQuotationService;

@Service
public class SalesQuotationService implements ISalesQuotationService {

    @Autowired
    private SalesQuotationDAO DAO;

    @Override
    public List<SalesQuotation> getAllQuotation() {
        return DAO.getAllQuotation();
    }

    @Override
    public SalesQuotation getQuotationById(int quotID) {
        return DAO.getQuotationById(quotID);
    }

    @Override
    public Long getNewQuottionID() {
        return DAO.getQuotationById();

    }

    @Override
    public void addnewQuotation(SalesQuotation quot) {
        DAO.addnewQuotation(quot);
    }

    @Override
    public List<Transport> getAllTransports() {
        return DAO.getAllTransports();
    }

    @Override
    public void updateQuotation(SalesQuotation qot) {
        DAO.updateQuotation(qot);
    }

    @Override
    public void deleteQuotation(int id) {
        DAO.deleteQuotation(id);
    }

    @Override
    public List<ContactPerson> getAllContacts() {
        return DAO.getAllContacts();
    }

}
