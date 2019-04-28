package com.concretepage.dao;

import com.concretepage.daointerface.IDeliveryGridDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.DeliveryGrid;
import com.concretepage.rowmapper.DeliveryGridRowMapper;
import com.concretepage.daointerface.IDeliveryGridDAO;

@Transactional
@Repository
public class DeliveryGridDAO implements IDeliveryGridDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DeliveryGrid getDeliveryGridById(int gridID) {
        //Day cai query ong sua o day
        //De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
        String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,"
                + "Price,Currency,vat,UomCode,DiscPrcnt,LineTotal,WhsCode,OpenQty FROM dbo.DLN1";
        RowMapper<DeliveryGrid> rowMapper = new DeliveryGridRowMapper();
        DeliveryGrid grid = jdbcTemplate.queryForObject(sql, rowMapper, gridID);
        return grid;
    }

    @Override
    public List<DeliveryGrid> getAllDeliveryGrids() {
        String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,"
                + "Price,Currency,vat,UomCode,DiscPrcnt,LineTotal,WhsCode,OpenQty FROM dbo.DLN1";
        RowMapper<DeliveryGrid> rowMapper = new DeliveryGridRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}
