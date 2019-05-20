/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.service;

import com.concretepage.dao.InPaymentDAO;
import com.concretepage.entity.InPayment;
import com.concretepage.iservice.IInPaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InPaymentService implements IInPaymentService {
    
    @Autowired
    private InPaymentDAO DAO;

    @Override
    public List<InPayment> getAllPayment() {
        return DAO.getAllPayment();
    }

    @Override
    public InPayment getPaymentById(int payID) {
        return DAO.getPaymentById(payID);
    }

    @Override
    public void addPayment(InPayment pay) {
        DAO.addPayment(pay);
    }

    @Override
    public void updatePayment(InPayment pay) {
        DAO.updatePayment(pay);
    }

    @Override
    public void deletePayment(int id) {
        DAO.deletePayment(id);
    }
    
}
