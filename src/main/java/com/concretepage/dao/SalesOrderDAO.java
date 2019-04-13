package com.concretepage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.SalesOrder;
import com.concretepage.rowmapper.SalesOrderRowMapper;
import com.concretepage.daointerface.ISalesOrderDAO;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.entity.SoGrid;
import com.concretepage.entity.SqGrid;
import com.concretepage.entity.Transport;
import com.concretepage.rowmapper.SalesQuotationRowMapper;
import com.concretepage.rowmapper.TransportRowMapper;

@Transactional
@Repository
public class SalesOrderDAO implements ISalesOrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SalesOrder getOrderById(int ordID) {
        //Day cai query ong sua o day
        //De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
        String sql = "select * from view_order where DocEntry = ?";
        RowMapper<SalesOrder> rowMapper = new SalesOrderRowMapper();
        SalesOrder ord = jdbcTemplate.queryForObject(sql, rowMapper, ordID);
        return ord;
    }

    @Override
    public List<SalesOrder> getAllOrder() {
        String sql = "SELECT * from view_order";
        RowMapper<SalesOrder> rowMapper = new SalesOrderRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Long getOrderById() {
        String sqll = "select max(DocNum) from dbo.ORDR";
        Long newid = jdbcTemplate.queryForObject(sqll, Long.class);
        return newid + 1;
    }

    public void addnewOrder(SalesOrder ord) {
        String sql1ll = "Select max(DocEntry) from dbo.ORDR";
        Long newDocEntry = jdbcTemplate.queryForObject(sql1ll, Long.class);
        String sql1 = "Select max(DocNum) from dbo.ORDR";
        Long newDocNum = jdbcTemplate.queryForObject(sql1, Long.class);
        String sqlll = "INSERT INTO dbo.ORDR (DocEntry,DocNum,CardCode,CardName,"
                + "CntctCode,SlpCode,OwnerCode,DocDate,"
                + "DocDueDate,TaxDate,ShipToCode,PayToCode,Address,"
                + "TrnspCode) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlll, newDocEntry + 1, newDocNum + 1, ord.getCode(),
                ord.getName(), ord.getContactName(),
                ord.getSaleEmployee(), ord.getEmployee(), ord.getDocDate(),
                ord.getDueDate(), ord.getTaxDate(), ord.getShipto(), ord.getBillto(),
                ord.getAddress(), ord.getTrasnport());
        String sql3 = "Select max(DocEntry) from dbo.RDR1";
        Long newgridid = jdbcTemplate.queryForObject(sql3, Long.class);
        String sql4 = "Select max(LineNum) from dbo.RDR1";
        Long newgridid1 = jdbcTemplate.queryForObject(sql3, Long.class);
        for (SoGrid soGrid : ord.getListItem()) {
            String sql2 = "INSERT INTO dbo.RDR1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,VatGroup,UomCode,TaxCode,LineTotal) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql2, newgridid + ord.getListItem().indexOf(soGrid) + 1,
                    newgridid + ord.getListItem().indexOf(soGrid) + 1, soGrid.getItemcode(), soGrid.getDescription(),
                    soGrid.getQuantity(), soGrid.getPrice(), soGrid.getCurrency(),
                    soGrid.getVatgroup(), soGrid.getTaxcode(), soGrid.getTotal());
        }
    }

    @Override
    public List<Transport> getAllTransports() {
        String sql = "SELECT TrnspCode, TrnspName from dbo.OSHP";
        RowMapper<Transport> rowMapper = new TransportRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void updateOrder(SalesOrder ord) {
        String sql_ord = "UPDATE dbo.ORDR SET CardCode=?, CardName=?, DocDueDate=? WHERE DocEntry=? ";
        jdbcTemplate.update(sql_ord, ord.getCode(), ord.getName(), ord.getDueDate(), ord.getId());

        for (SoGrid soGrid : ord.getListItem()) {
            String sql_item = "update dbo.QUT1 set ItemCode = ?, Quantity = ?, Price = ?, TaxCode = ?"
                    + " where DocEntry = ?";
            //sql1
            jdbcTemplate.update(sql_item, soGrid.getItemcode(), soGrid.getQuantity(), soGrid.getPrice(),
                    soGrid.getTaxcode(), soGrid.getId());
        }

    }

    @Override
    public void deleteOrder(int id) {
        String sql = "DELETE from dbo.ORDR WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<SalesQuotation> getListQuotation() {
        String sql = "SELECT * from view_quotation where Ref1 IS NULL";
        RowMapper<SalesQuotation> rowMapper = new SalesQuotationRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void copyQuotation(SalesQuotation quot) {
        String sql = "INSERT INTO dbo.ORDR (select * from view_quotation where Ref1 IS NULL)";
        jdbcTemplate.update(sql, quot.getRef());
    }

}
