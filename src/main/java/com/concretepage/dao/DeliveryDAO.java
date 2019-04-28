package com.concretepage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Delivery;
import com.concretepage.rowmapper.DeliveryRowMapper;
import com.concretepage.daointerface.IDeliveryDAO;
import com.concretepage.entity.DeliveryGrid;
import com.concretepage.entity.SalesOrder;
import com.concretepage.entity.SoGrid;
import com.concretepage.entity.Transport;
import com.concretepage.rowmapper.DeliveryGridRowMapper;
import com.concretepage.rowmapper.SoGridRowMapper;
import com.concretepage.rowmapper.TransportRowMapper;

@Transactional
@Repository
public class DeliveryDAO implements IDeliveryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Delivery getDeliveryById(int delvID) {
        String sql = "SELECT * from view_delivery where DocEntry = ?";
        RowMapper<Delivery> rowMapper = new DeliveryRowMapper();
        Delivery delv = jdbcTemplate.queryForObject(sql, rowMapper, delvID);
        String sql_items = "select * from dbo.DLN1 where DocEntry = ?";
        RowMapper<DeliveryGrid> rowMapper_item = new DeliveryGridRowMapper();
        List<DeliveryGrid> items = jdbcTemplate.query(sql_items, rowMapper_item, delvID);
        delv.setListItem(items);
        return delv;
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        String sql = "SELECT * from view_delivery";
        RowMapper<Delivery> rowMapper = new DeliveryRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Long getDeliveryById() {
        String sqll = "select max(DocNum) from dbo.ODLN";
        Long newid = jdbcTemplate.queryForObject(sqll, Long.class);
        return newid + 1;
    }

    public void addnewDelivery(Delivery delv) {
        String sql1ll = "Select max(DocEntry) from dbo.ODLN";
        Long newDocEntry = jdbcTemplate.queryForObject(sql1ll, Long.class);
        String sql1 = "Select max(DocNum) from dbo.ODLN";
        Long newDocNum = jdbcTemplate.queryForObject(sql1, Long.class);
        String sqlll = "INSERT INTO dbo.ODLN (DocEntry,DocNum,CardCode,CardName,"
                + "CntctCode,DocCur,SlpCode,OwnerCode,DocDate,"
                + "DocDueDate,TaxDate,ShipToCode,Address2,"
                + "TrnspCode) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlll, newDocEntry + 1, newDocNum + 1, delv.getCode(),
                delv.getName(), delv.getContactName(), delv.getCurrency(), delv.getSaleEmployee(), delv.getEmployee(), delv.getDocDate(),
                delv.getDueDate(), delv.getTaxDate(), delv.getShipto(),
                delv.getAddress(), delv.getTrasnport());

        for (DeliveryGrid delvGrid : delv.getListItem()) {
            String sql4 = "Select max(LineNum) from dbo.DLN1";
            Long new_linenum = jdbcTemplate.queryForObject(sql4, Long.class);
            String sql2 = "INSERT INTO dbo.DLN1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,vat,DiscPrcnt,LineTotal,UomCode,WhsCode) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql2, newDocEntry + delv.getListItem().indexOf(delvGrid) + 1,
                    new_linenum + delv.getListItem().indexOf(delvGrid) + 1, delvGrid.getItemcode(), delvGrid.getDescription(),
                    delvGrid.getQuantity(), delvGrid.getPrice(), delvGrid.getCurrency(),
                    delvGrid.getVat(), delvGrid.getDiscount(), delvGrid.getTotal(), delvGrid.getUomcode(), delvGrid.getWarehouse());
        }
    }

    @Override
    public List<Transport> getAllTransports() {
        String sql = "SELECT TrnspCode, TrnspName from dbo.OSHP";
        RowMapper<Transport> rowMapper = new TransportRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void updateDelivery(Delivery delv) {
        String sql = "UPDATE dbo.ODLN SET  DocDueDate=? WHERE DocEntry=? ";
        jdbcTemplate.update(sql, delv.getDueDate(), delv.getId());

        for (DeliveryGrid delvGrid : delv.getListItem()) {
            String sql_item = "update dbo.DLN1 set  Quantity = ?"
                    + " where DocEntry = ?";
            //sql1
            jdbcTemplate.update(sql_item, delvGrid.getQuantity(), delvGrid.getId());

        }
    }

    @Override
    public void deleteDelivery(int id) {
        String sql = "DELETE from dbo.ODLN WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
        String sql_grid = "DELETE from dbo.DLN1 WHERE DocEntry = ?";
        jdbcTemplate.update(sql_grid, id);
    }
}
