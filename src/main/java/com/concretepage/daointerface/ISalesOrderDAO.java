package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.Transport;

public interface ISalesOrderDAO {

    List<SalesOrder> getAllOrder();

    SalesOrder getOrderById(int ordID);
    
    List<Transport> getAllTransports();
    
    public void deleteOrder(int id);
    
    List<SalesQuotation> getListQuotation();
    
    
}
