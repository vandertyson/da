package com.concretepage.iservice;

import com.concretepage.entity.InPayment;
import java.util.List;


public interface IInPaymentService {

    List<InPayment> getAllPayment();

    InPayment getPaymentById(int payID);

    public void addPayment(InPayment pay);

    public void updatePayment(InPayment pay);

    public void deletePayment(int id);

}
