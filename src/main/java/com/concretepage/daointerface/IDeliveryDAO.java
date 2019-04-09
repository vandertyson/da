package com.concretepage.daointerface;

import java.util.List;
import com.concretepage.entity.Delivery;
import com.concretepage.entity.Transport;

public interface IDeliveryDAO {

    List<Delivery> getAllDeliveries();

    Delivery getDeliveryById(int delvID);

    List<Transport> getAllTransports();

    public void deleteDelivery(int id);
}
