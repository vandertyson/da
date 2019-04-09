package com.concretepage.service;

import com.concretepage.dao.SqGridDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.SqGrid;
import com.concretepage.daointerface.ISqGridDAO;
import com.concretepage.iservice.ISqGridService;

@Service
public class SqGridService implements ISqGridService {

    @Autowired
    private SqGridDAO DAO;

    @Override
    public List<SqGrid> getAllSqGrid() {
        return DAO.getAllSqGrid();
    }

    @Override
    public SqGrid getSqGridById(int gridID) {
        return DAO.getSqGridById(gridID);
    }

}
