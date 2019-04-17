package com.concretepage.service;

import com.concretepage.dao.ArGridDAO;
import com.concretepage.dao.DeliveryGridDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.DeliveryGrid;
import com.concretepage.daointerface.IDeliveryGridDAO;
import com.concretepage.entity.ArGrid;
import com.concretepage.iservice.IArGridService;
import com.concretepage.iservice.IDeliveryGridService;

@Service
public class ArGridService implements IArGridService {

    @Autowired
    private ArGridDAO DAO;

    @Override
    public List<ArGrid> getAllArGrids() {
        return DAO.getAllArGrids();
    }

    @Override
    public ArGrid getArGridById(int gridID) {
        return DAO.getArGridById(gridID);
    }

}
