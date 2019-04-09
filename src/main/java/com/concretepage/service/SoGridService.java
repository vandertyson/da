package com.concretepage.service;

import com.concretepage.dao.SoGridDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.SoGrid;
import com.concretepage.daointerface.ISoGridDAO;
import com.concretepage.iservice.ISoGridService;

@Service
public class SoGridService implements ISoGridService {

    @Autowired
    private SoGridDAO DAO;

    @Override
    public List<SoGrid> getAllSoGrid() {
        return DAO.getAllSoGrid();
    }

    @Override
    public SoGrid getSoGridById(int gridID) {
        return DAO.getSoGridById(gridID);
    }

}
