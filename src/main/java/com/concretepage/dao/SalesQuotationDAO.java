package com.concretepage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.SalesQuotation;
import com.concretepage.rowmapper.SalesQuotationRowMapper;
import com.concretepage.daointerface.ISalesQuotationDAO;
import com.concretepage.entity.ContactPerson;
import com.concretepage.entity.Item;
import com.concretepage.entity.SqGrid;
import com.concretepage.entity.Stat;
import com.concretepage.entity.Transport;
import com.concretepage.rowmapper.ContactPersonRowMapper;
import com.concretepage.rowmapper.ItemRowMapper;
import com.concretepage.rowmapper.SqGridRowMapper;
import com.concretepage.rowmapper.TransportRowMapper;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;

@Transactional
@Repository
public class SalesQuotationDAO implements ISalesQuotationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SalesQuotation getQuotationById(int quotID) {
        String sql = "select * from view_quotation where DocEntry = ?";
        RowMapper<SalesQuotation> rowMapper = new SalesQuotationRowMapper();
        SalesQuotation quot = jdbcTemplate.queryForObject(sql, rowMapper, quotID);
        String sql_items = "select * from dbo.QUT1 where DocEntry = ?";
        RowMapper<SqGrid> rowMapper_item = new SqGridRowMapper();
        List<SqGrid> items = jdbcTemplate.query(sql_items, rowMapper_item, quotID);
        quot.setListItem(items);
        return quot;
    }

    @Override
    public List<SalesQuotation> getAllQuotation() {
        String sql = "select * from view_quotation where DocStatus = 'C' order by DocEntry DESC";
        RowMapper<SalesQuotation> rowMapper = new SalesQuotationRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Long getQuotationById() {
        String sqll = "select max(DocEntry) from dbo.OQUT";
        Long newid = jdbcTemplate.queryForObject(sqll, Long.class);
        return newid + 1;
    }

    public void addnewQuotation(SalesQuotation quot) {
        String sql1ll = "Select max(DocEntry) from dbo.OQUT";
        Long newDocEntry = jdbcTemplate.queryForObject(sql1ll, Long.class);
        String sql1 = "Select max(DocNum) from dbo.OQUT";
        Long newDocNum = jdbcTemplate.queryForObject(sql1, Long.class);
        String sql_insert = "INSERT INTO dbo.OQUT (DocEntry,DocNum,CardCode,CardName,"
                + "CntctCode,DocCur,SlpCode,OwnerCode,DocDate,"
                + "DocDueDate,TaxDate) values (?,?,?,"
                + "?,?,?,"
                + "?,?,?,?,?)";
        //quot.setDocstatus("0");
        jdbcTemplate.update(sql_insert, newDocEntry + 1, newDocNum + 1,
                quot.getCode(), quot.getName(), quot.getContactCode(), quot.getCurrency(),
                quot.getSaleEmployee(), quot.getEmployee(), quot.getDocDate(),
                quot.getDueDate(), quot.getTaxDate());

        for (SqGrid sqGrid : quot.getListItem()) {
            String sql4 = "Select max(LineNum) from dbo.QUT1";
            Long new_linenum = jdbcTemplate.queryForObject(sql4, Long.class);
            String sql2 = "INSERT INTO dbo.QUT1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,vat,"
                    + "DiscPrcnt,LineTotal,UomCode) "
                    + "values (?,?,?,?"
                    + ",?,?,?,?"
                    + ",?,?,?)";
            jdbcTemplate.update(sql2,
                    newDocEntry + quot.getListItem().indexOf(sqGrid) + 1,
                    new_linenum + quot.getListItem().indexOf(sqGrid) + 1,
                    sqGrid.getItemcode(), sqGrid.getDescription(),
                    sqGrid.getQuantity(), sqGrid.getPrice(), sqGrid.getCurrency(),
                    sqGrid.getVat(), sqGrid.getDiscount(), sqGrid.getTotal(), sqGrid.getUomcode());
        }
    }

    @Override
    public List<Transport> getAllTransports() {
        String sql = "SELECT TrnspCode, TrnspName from dbo.OSHP";
        RowMapper<Transport> rowMapper = new TransportRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<ContactPerson> getAllContacts() {
        String sql = "SELECT CntctCode, Name, Position from dbo.OCPR";
        RowMapper<ContactPerson> rowMapper = new ContactPersonRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void updateQuotation(SalesQuotation qot) {
        String sql_quot = "UPDATE dbo.OQUT SET DocCur = ?, DocDueDate = ?, SlpCode = ? WHERE DocEntry = ?";
        jdbcTemplate.update(sql_quot, qot.getCurrency(), qot.getDueDate(), qot.getSaleEmployee(), qot.getId());

        for (SqGrid sqGrid : qot.getListItem()) {
            String sql_item = "update dbo.QUT1 set Quantity = ?"
                    + " where DocEntry = ?";
            //sql1
            jdbcTemplate.update(sql_item, sqGrid.getQuantity(), sqGrid.getId());
        }

    }

    @Override
    public void deleteQuotation(int id) {
        String sql = "DELETE from dbo.OQUT WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
        String sql_grid = "DELETE from dbo.QUT1 WHERE DocEntry = ?";
        jdbcTemplate.update(sql_grid, id);
    }

    public boolean confirmQuotation(Integer quot_id, String stat) {
        String sql = "update dbo.OQUT SET DocStatus = ? where DocEntry = ?";
        int update = jdbcTemplate.update(sql, stat, quot_id);
        return update > 0;
    }

    public List<SalesQuotation> getQuotByStatus(String status) {
        String sql = "select * from view_quotation where DocStatus = ? order by DocEntry DESC";
        RowMapper<SalesQuotation> rowMapper = new SalesQuotationRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper, status);
    }

    public List<Stat> countQuot() {
        String sql_quot = "SELECT COUNT(*) FROM view_quotation;";        
        String sql_order = "SELECT COUNT(*) FROM view_order;";        
        String sql_delivery = "SELECT COUNT(*) FROM view_delivery;";        
        String sql_invoice = "SELECT COUNT(*) FROM view_ar;";        
        
        List<Stat> result = new ArrayList<Stat>();        
        result.add(new Stat("Created Sales Quotation",jdbcTemplate.queryForObject(sql_quot, Integer.class)));
        result.add(new Stat("Created Sales Order",jdbcTemplate.queryForObject(sql_order, Integer.class)));
        result.add(new Stat("Created Delivery",jdbcTemplate.queryForObject(sql_delivery, Integer.class)));
        result.add(new Stat("Created AR-Invoice",jdbcTemplate.queryForObject(sql_invoice, Integer.class)));        
        return result;
    }

    public List<SalesQuotation> getQuotByCustomer(String code) {
        String sql = "SELECT * FROM view_quotation where CardCode = ?";
        RowMapper<SalesQuotation> rowMapper = new SalesQuotationRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper, code);
    }

}
