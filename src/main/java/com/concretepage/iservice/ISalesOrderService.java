package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;

public interface ISalesOrderService {

    List<SalesOrder> getAllOrder();

    List<Transport> getAllTransports();

    SalesOrder getOrderById(int ordID);

    public Long getNewOrderID();

    public void addnewOrder(SalesOrder ord);
    
    public void updateOrder(SalesOrder ord);
    
    public void deleteOrder(int id);

    public List<SalesQuotation> getListQuotation();

    public void copyQuotation(SalesQuotation quot);

}
