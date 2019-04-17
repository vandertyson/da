package com.concretepage.dao;

import com.concretepage.daointerface.IArGridDAO;
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
import com.concretepage.entity.ArGrid;
import com.concretepage.rowmapper.ArGridRowMapper;

@Transactional
@Repository
public class ArGridDAO implements IArGridDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArGrid getArGridById(int gridID) {
        //Day cai query ong sua o day
        //De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
        String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,"
                + "Price,Currency,VatGroup,UomCode,TaxCode,LineTotal,WhsCode FROM dbo.INV1";
        RowMapper<ArGrid> rowMapper = new ArGridRowMapper();
        ArGrid grid = jdbcTemplate.queryForObject(sql, rowMapper, gridID);
        return grid;
    }

    @Override
    public List<ArGrid> getAllArGrids() {
        String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,"
                + "Price,Currency,VatGroup,UomCode,TaxCode,LineTotal,WhsCode FROM dbo.INV1";
        RowMapper<ArGrid> rowMapper = new ArGridRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}
