/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.daointerface;

import com.concretepage.entity.InPayment;
import com.concretepage.entity.SalesQuotation;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IInPaymentDAO {

    List<InPayment> getAllPayment();

    InPayment getPaymentById(int payID);

    public void deletePayment(int id);

    public void addPayment(InPayment pay);
    
    public void updatePayment(InPayment pay);
}
