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
import com.concretepage.entity.SqGrid;
import com.concretepage.entity.Transport;
import com.concretepage.rowmapper.ContactPersonRowMapper;
import com.concretepage.rowmapper.TransportRowMapper;

@Transactional
@Repository
public class SalesQuotationDAO implements ISalesQuotationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SalesQuotation getQuotationById(int quotID) {
        //Day cai query ong sua o day
        //De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
        String sql = "select * from view_quotation where DocEntry = ?";
        RowMapper<SalesQuotation> rowMapper = new SalesQuotationRowMapper();
        SalesQuotation quot = jdbcTemplate.queryForObject(sql, rowMapper, quotID);
        return quot;
    }

    @Override
    public List<SalesQuotation> getAllQuotation() {
        String sql = "select * from view_quotation";
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
                + "CntctCode,SlpCode,OwnerCode,DocDate,"
                + "DocDueDate,TaxDate,DocStatus) values (?,?,?,"
                + "?,?,?,"
                + "?,?,?,?,?)";
        quot.setDocstatus("0");
        jdbcTemplate.update(sql_insert, newDocEntry + 1, newDocNum + 1,
                quot.getCode(), quot.getName(), quot.getContactName(),
                quot.getSaleEmployee(), quot.getEmployee(), quot.getDocDate(),
                quot.getDueDate(), quot.getTaxDate(), "0");

        String sql3 = "Select max(DocEntry) from dbo.QUT1";
        Long newgridid = jdbcTemplate.queryForObject(sql3, Long.class);
        String sql4 = "Select max(LineNum) from dbo.QUT1";
        Long newgridid1 = jdbcTemplate.queryForObject(sql4, Long.class);
        for (SqGrid sqGrid : quot.getListItem()) {
            String sql2 = "INSERT INTO dbo.QUT1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,VatGroup,"
                    + "UomCode,TaxCode,LineTotal) "
                    + "values (?,?,?,?"
                    + ",?,?,?,?"
                    + ",?,?,?)";
            jdbcTemplate.update(sql2, 
                    newgridid + quot.getListItem().indexOf(sqGrid) + 1,
                    newgridid + quot.getListItem().indexOf(sqGrid) + 1, 
                    sqGrid.getItemcode(), sqGrid.getDescription(),
                    sqGrid.getQuantity(), sqGrid.getPrice(), sqGrid.getCurrency(),
                    sqGrid.getVatgroup(), sqGrid.getTaxcode(), sqGrid.getTotal(), sqGrid.getUomcode());
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
        String sql = "SELECT CntctCode, Name, Position, Tell, E_MaiL from dbo.OCPR";
        RowMapper<ContactPerson> rowMapper = new ContactPersonRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void updateQuotation(SalesQuotation qot) {
        String sql_quot = "UPDATE dbo.OQUT SET CardCode = ?, CardName = ?, DocDueDate=?, SlpCode = ? WHERE DocEntry = ?";
        jdbcTemplate.update(sql_quot, qot.getCode(), qot.getName(), qot.getDueDate(), qot.getSaleEmployee(), qot.getId());

        for (SqGrid sqGrid : qot.getListItem()) {
            String sql_item = "update dbo.QUT1 set ItemCode = ?, Quantity = ?, Price = ?, TaxCode = ?"
                    + " where DocEntry = ?";
            //sql1
            jdbcTemplate.update(sql_item, sqGrid.getItemcode(), sqGrid.getQuantity(), sqGrid.getPrice(), sqGrid.getTaxcode(), sqGrid.getId());
        }
    }

    @Override
    public void deleteQuotation(int id) {
        String sql = "DELETE from dbo.OQUT WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
    }

}
