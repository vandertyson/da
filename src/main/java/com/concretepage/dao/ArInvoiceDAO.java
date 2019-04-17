package com.concretepage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.ArInvoice;
import com.concretepage.rowmapper.ArInvoiceRowMapper;
import com.concretepage.daointerface.IArInvoiceDAO;
import com.concretepage.entity.DeliveryGrid;

@Transactional
@Repository
public class ArInvoiceDAO implements IArInvoiceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArInvoice getInvoiceById(int invID) {
        //Day cai query ong sua o day
        //De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
        String sql = "SELECT DocEntry,DocNum,CardCode,CardName,"
                + "OwnerCode,DocDate,DocDueDate,TaxDate,ShipToCode,"
                + "Address2,TrnspCode FROM dbo.OINV WHERE ID = ?";
        RowMapper<ArInvoice> rowMapper = new ArInvoiceRowMapper();
        ArInvoice inv = jdbcTemplate.queryForObject(sql, rowMapper, invID);
        return inv;
    }

    @Override
    public List<ArInvoice> getAllInvoices() {
        String sql = "SELECT DocEntry,DocNum,CardCode,CardName,"
                + "OwnerCode,DocDate,DocDueDate,TaxDate,ShipToCode,"
                + "Address2,TrnspCode FROM dbo.OINV";
        RowMapper<ArInvoice> rowMapper = new ArInvoiceRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Long getInvoiceById() {
        String sqll = "select max(DocNum) from dbo.OINV";
        Long newid = jdbcTemplate.queryForObject(sqll, Long.class);
        return newid + 1;
    }

    public void addnewInvoice(ArInvoice inv) {
        String sql1ll = "Select max(DocEntry) from dbo.OINV";
        Long newDocEntry = jdbcTemplate.queryForObject(sql1ll, Long.class);
        String sql1 = "Select max(DocNum) from dbo.OINV";
        Long newDocNum = jdbcTemplate.queryForObject(sql1, Long.class);
        String sqlll = "INSERT INTO dbo.OINV (DocEntry,DocNum,CardCode,CardName,"
                + "OwnerCode,DocDate,"
                + "DocDueDate,TaxDate,ShipToCode,Address2,"
                + "TrnspCode) values (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlll, newDocEntry + 1, newDocNum + 1, inv.getCode(),
                inv.getName(), inv.getEmployee(), inv.getDocDate(),
                inv.getDueDate(), inv.getTaxDate(), inv.getShipto(),
                inv.getAddress(), inv.getTrasnport());
        String sql3 = "Select max(DocEntry) from dbo.INV1";
        Long newgridid = jdbcTemplate.queryForObject(sql3, Long.class);
        String sql4 = "Select max(LineNum) from dbo.DLN1";
        Long newgridid1 = jdbcTemplate.queryForObject(sql3, Long.class);
        for (DeliveryGrid delvGrid : inv.getListItem()) {
            String sql2 = "INSERT INTO dbo.INV1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,VatGroup,TaxCode,LineTotal) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql2, newgridid + inv.getListItem().indexOf(delvGrid) + 1,
                    newgridid + inv.getListItem().indexOf(delvGrid) + 1, delvGrid.getItemcode(), delvGrid.getDescription(),
                    delvGrid.getQuantity(), delvGrid.getPrice(), delvGrid.getCurrency(),
                    delvGrid.getVatgroup(), delvGrid.getTaxcode(), delvGrid.getTotal());
        }
    }

}
