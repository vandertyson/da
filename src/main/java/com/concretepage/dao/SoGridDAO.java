package com.concretepage.dao;

import com.concretepage.daointerface.ISoGridDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.SoGrid;
import com.concretepage.rowmapper.SoGridRowMapper;
import com.concretepage.daointerface.ISqGridDAO;

@Transactional
@Repository
public class SoGridDAO implements ISoGridDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SoGrid getSoGridById(int gridID) {
        //Day cai query ong sua o day
        //De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
        String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,Price,"
                + "Currency,VatGroup,TaxCode,UomCode,LineTotal,WhsCode,OpenQty FROM dbo.RDR1";
        RowMapper<SoGrid> rowMapper = new SoGridRowMapper();
        SoGrid grid = jdbcTemplate.queryForObject(sql, rowMapper, gridID);
        return grid;
    }

    @Override
    public List<SoGrid> getAllSoGrid() {
        String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,Price,"
                + "Currency,VatGroup,TaxCode,UomCode,LineTotal,WhsCode,OpenQty FROM dbo.RDR1";
        RowMapper<SoGrid> rowMapper = new SoGridRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}
