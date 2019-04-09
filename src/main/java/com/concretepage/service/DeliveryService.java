package com.concretepage.service;

import com.concretepage.dao.DeliveryDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.Delivery;
import com.concretepage.daointerface.IDeliveryDAO;
import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.Transport;
import com.concretepage.iservice.IDeliveryService;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    private DeliveryDAO DAO;

    @Override
    public List<Delivery> getAllDeliveries() {
        return DAO.getAllDeliveries();
    }

    @Override
    public Delivery getDeliveryById(int delvID) {
        return DAO.getDeliveryById(delvID);
    }

    @Override
    public Long getNewDeliveryID() {
        return DAO.getDeliveryById();

    }

    @Override
    public void addnewDelivery(Delivery delv) {
        DAO.addnewDelivery(delv);
    }

    @Override
    public List<Transport> getAllTransports() {
        return DAO.getAllTransports();
    }

    @Override
    public void deleteDelivery(int id) {
        DAO.deleteDelivery(id);
    }

    @Override
    public void updateDelivery(Delivery delv) {
        DAO.updateDelivery(delv);
    }

}
