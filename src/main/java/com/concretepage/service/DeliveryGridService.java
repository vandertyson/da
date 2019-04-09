package com.concretepage.service;

import com.concretepage.dao.DeliveryGridDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.DeliveryGrid;
import com.concretepage.daointerface.IDeliveryGridDAO;
import com.concretepage.iservice.IDeliveryGridService;

@Service
public class DeliveryGridService implements IDeliveryGridService {

    @Autowired
    private DeliveryGridDAO DAO;

    @Override
    public List<DeliveryGrid> getAllDeliveryGrids() {
        return DAO.getAllDeliveryGrids();
    }

    @Override
    public DeliveryGrid getDeliveryGridById(int gridID) {
        return DAO.getDeliveryGridById(gridID);
    }

}
