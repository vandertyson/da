package com.concretepage.iservice;

import java.util.List;

import com.concretepage.entity.Delivery;
import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.Transport;

public interface IDeliveryService {

    List<Delivery> getAllDeliveries();

    List<Transport> getAllTransports();

    Delivery getDeliveryById(int delvID);

    public Long getNewDeliveryID();

    public void addnewDelivery(Delivery delv);

    public void updateDelivery(Delivery delv);

    public void deleteDelivery(int id);
}
