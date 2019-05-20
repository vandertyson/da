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
import com.concretepage.rowmapper.SoGridRowMapper;
import com.concretepage.rowmapper.SqGridRowMapper;
import com.concretepage.rowmapper.TransportRowMapper;

@Transactional
@Repository
public class SalesOrderDAO implements ISalesOrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SalesOrder getOrderById(int ordID) {
        String sql = "select * from view_order where DocEntry = ?";
        RowMapper<SalesOrder> rowMapper = new SalesOrderRowMapper();
        SalesOrder ord = jdbcTemplate.queryForObject(sql, rowMapper, ordID);
        String sql_items = "select * from dbo.RDR1 where DocEntry = ?";
        RowMapper<SoGrid> rowMapper_item = new SoGridRowMapper();
        List<SoGrid> items = jdbcTemplate.query(sql_items, rowMapper_item, ordID);
        ord.setListItem(items);
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
                + "CntctCode,DocCur,SlpCode,OwnerCode,DocDate,"
                + "DocDueDate,TaxDate,ShipToCode,Address2,"
                + "TrnspCode) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlll, newDocEntry + 1, newDocNum + 1, ord.getCode(),
                ord.getName(), ord.getContactCode(), ord.getCurrency(),
                ord.getSaleEmployee(), ord.getEmployee(), ord.getDocDate(),
                ord.getDueDate(), ord.getTaxDate(), ord.getShipto(),
                ord.getAddress(), ord.getTrasnport());

        for (SoGrid soGrid : ord.getListItem()) {
            String sql4 = "Select max(LineNum) from dbo.RDR1";
            Long new_linenum = jdbcTemplate.queryForObject(sql4, Long.class);

            String sql2 = "INSERT INTO dbo.RDR1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,vat,DiscPrcnt,LineTotal,UomCode,WhsCode) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql2, newDocEntry + ord.getListItem().indexOf(soGrid) + 1,
                    new_linenum + ord.getListItem().indexOf(soGrid) + 1, soGrid.getItemcode(), soGrid.getDescription(),
                    soGrid.getQuantity(), soGrid.getPrice(), soGrid.getCurrency(),
                    soGrid.getVat(), soGrid.getDiscount(), soGrid.getTotal(), soGrid.getUomcode(),
                    soGrid.getWarehouse());
        }
    }

    @Override
    public List<Transport> getAllTransports() {
        String sql = "SELECT TrnspCode, TrnspName from dbo.OSHP";
        RowMapper<Transport> rowMapper = new TransportRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void updateOrder(SalesOrder ord) {
        String sql_ord = "UPDATE dbo.ORDR SET DocDueDate=? WHERE DocEntry=? ";
        jdbcTemplate.update(sql_ord, ord.getDueDate(), ord.getId());

        for (SoGrid soGrid : ord.getListItem()) {
            String sql_item = "update dbo.RDR1 set  Quantity = ?"
                    + " where DocEntry = ?";
            //sql1
            jdbcTemplate.update(sql_item, soGrid.getQuantity(), soGrid.getId());
        }

    }

    @Override
    public void deleteOrder(int id) {
        String sql = "DELETE from dbo.ORDR WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
        String sql_grid = "DELETE from dbo.RDR1 WHERE DocEntry = ?";
        jdbcTemplate.update(sql_grid, id);
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

    public boolean confirmOrder(Integer ord_id, String stat) {
        String sql = "update dbo.ORDR SET DocStatus = ? where DocEntry = ?";
        int update = jdbcTemplate.update(sql, stat, ord_id);
        return update > 0;
    }

    public List<SalesOrder> getOrderByStatus(String status) {
        String sql = "select * from view_order where DocStatus = ? order by DocEntry DESC";
        RowMapper<SalesOrder> rowMapper = new SalesOrderRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper, status);
    }

    public boolean printOrder(Integer ord_id, String print) {
        String sql = "update dbo.ORDR SET Printed = ? where DocEntry = ?";
        int update = jdbcTemplate.update(sql, print, ord_id);
        return update > 0;
    }

    public boolean update(Integer ord_id, String itemID, Integer num) {
        String sql_da_xuat = "Select AccumulateQty from dbo.RDR1 WHERE DocEntry = ? and ItemCode = ?";
        Double da_xuat = jdbcTemplate.queryForObject(sql_da_xuat, new Object[]{ord_id, itemID}, Double.class);
        da_xuat = da_xuat == null ? 0 : da_xuat;
        String sql = "UPDATE dbo.RDR1 SET AccumulateQty = ? WHERE DocEntry = ? and ItemCode = ?";
        int update = jdbcTemplate.update(sql, num + da_xuat, ord_id, itemID);
        return update > 0;
    }
}
