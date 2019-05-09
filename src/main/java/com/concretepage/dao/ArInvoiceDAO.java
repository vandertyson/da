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
import com.concretepage.entity.ArGrid;
import com.concretepage.entity.Delivery;
import com.concretepage.entity.DeliveryGrid;
import com.concretepage.entity.Transport;
import com.concretepage.rowmapper.ArGridRowMapper;
import com.concretepage.rowmapper.DeliveryGridRowMapper;
import com.concretepage.rowmapper.TransportRowMapper;

@Transactional
@Repository
public class ArInvoiceDAO implements IArInvoiceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArInvoice getInvoiceById(int invID) {
        String sql = "SELECT * from view_ar WHERE DocEntry = ?";
        RowMapper<ArInvoice> rowMapper = new ArInvoiceRowMapper();
        ArInvoice inv = jdbcTemplate.queryForObject(sql, rowMapper, invID);
        String sql_items = "select * from dbo.INV1 where DocEntry = ?";
        RowMapper<ArGrid> rowMapper_item = new ArGridRowMapper();
        List<ArGrid> items = jdbcTemplate.query(sql_items, rowMapper_item, invID);
        inv.setListItem(items);
        return inv;
    }

    @Override
    public List<ArInvoice> getAllInvoices() {
        String sql = "SELECT * FROM view_ar";
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
                + "CntctCode,DocCur,SlpCode,OwnerCode,DocDate,"
                + "DocDueDate,TaxDate,ShipToCode,Address2,"
                + "TrnspCode) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlll, newDocEntry + 1, newDocNum + 1, inv.getCode(),
                inv.getName(), inv.getContactName(), inv.getCurrency(), inv.getSaleEmployee(), inv.getEmployee(), inv.getDocDate(),
                inv.getDueDate(), inv.getTaxDate(), inv.getShipto(),
                inv.getAddress(), inv.getTrasnport());

        for (ArGrid arGrid : inv.getListItem()) {
            String sql4 = "Select max(LineNum) from dbo.INV1";
            Long new_linenum = jdbcTemplate.queryForObject(sql4, Long.class);

            String sql2 = "INSERT INTO dbo.INV1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,vat,DiscPrcnt,LineTotal,UomCode,WhsCode) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql2, newDocEntry + inv.getListItem().indexOf(arGrid) + 1,
                    new_linenum + inv.getListItem().indexOf(arGrid) + 1, arGrid.getItemcode(), arGrid.getDescription(),
                    arGrid.getQuantity(), arGrid.getPrice(), arGrid.getCurrency(),
                    arGrid.getVatgroup(), arGrid.getTaxcode(), arGrid.getTotal(),
                    arGrid.getUomcode(), arGrid.getWarehouse());
        }
    }

    @Override
    public List<Transport> getAllTransports() {
        String sql = "SELECT TrnspCode, TrnspName from dbo.OSHP";
        RowMapper<Transport> rowMapper = new TransportRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void updateInvoice(ArInvoice inv) {
        String sql = "UPDATE dbo.OINV SET  DocDueDate=? WHERE DocEntry=? ";
        jdbcTemplate.update(sql, inv.getDueDate(), inv.getId());

        for (ArGrid arGrid : inv.getListItem()) {
            String sql_item = "update dbo.INV1 set  Quantity = ?"
                    + " where DocEntry = ?";
            //sql1
            jdbcTemplate.update(sql_item, arGrid.getQuantity(), arGrid.getId());

        }
    }

    @Override
    public void deleteInvoice(int id) {
        String sql = "DELETE from dbo.OINV WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
        String sql_grid = "DELETE from dbo.INV1 WHERE DocEntry = ?";
        jdbcTemplate.update(sql_grid, id);
    }
}
