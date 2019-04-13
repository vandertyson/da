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
import com.concretepage.entity.Transport;
import com.concretepage.rowmapper.TransportRowMapper;

@Transactional
@Repository
public class DeliveryDAO implements IDeliveryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Delivery getDeliveryById(int delvID) {
        //Day cai query ong sua o day
        //De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
        String sql = "SELECT DocEntry,DocNum,CardCode,CardName,"
                + "OwnerCode,DocDate,DocDueDate,TaxDate,ShipToCode,"
                + "Address2,TrnspCode FROM dbo.ODLN WHERE ID = ?";
        RowMapper<Delivery> rowMapper = new DeliveryRowMapper();
        Delivery delv = jdbcTemplate.queryForObject(sql, rowMapper, delvID);
        return delv;
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        String sql = "SELECT DocEntry,DocNum,CardCode,CardName,"
                + "OwnerCode,DocDate,DocDueDate,TaxDate,ShipToCode,"
                + "Address2,TrnspCode FROM dbo.ODLN";
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
                + "OwnerCode,DocDate,"
                + "DocDueDate,TaxDate,ShipToCode,Address2,"
                + "TrnspCode) values (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlll, newDocEntry + 1, newDocNum + 1, delv.getCode(),
                delv.getName(), delv.getEmployee(), delv.getDocDate(),
                delv.getDueDate(), delv.getTaxDate(), delv.getShipto(),
                delv.getAddress(), delv.getTrasnport());
        String sql3 = "Select max(DocEntry) from dbo.DLN1";
        Long newgridid = jdbcTemplate.queryForObject(sql3, Long.class);
        String sql4 = "Select max(LineNum) from dbo.DLN1";
        Long newgridid1 = jdbcTemplate.queryForObject(sql3, Long.class);
        for (DeliveryGrid delvGrid : delv.getListItem()) {
            String sql2 = "INSERT INTO dbo.DLN1 (DocEntry,LineNum,ItemCode,Dscription,"
                    + "Quantity,Price,Currency,VatGroup,TaxCode,LineTotal) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql2, newgridid + delv.getListItem().indexOf(delvGrid) + 1,
                    newgridid + delv.getListItem().indexOf(delvGrid) + 1, delvGrid.getItemcode(), delvGrid.getDescription(),
                    delvGrid.getQuantity(), delvGrid.getPrice(), delvGrid.getCurrency(),
                    delvGrid.getVatgroup(), delvGrid.getTaxcode(), delvGrid.getTotal());
        }
    }

    @Override
    public List<Transport> getAllTransports() {
        String sql = "SELECT TrnspCode, TrnspName from dbo.OSHP";
        RowMapper<Transport> rowMapper = new TransportRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void updateDelivery(Delivery delv) {
        String sql = "UPDATE dbo.ODLN SET CardCode=?, CardName=?, DocDueDate=? WHERE DocEntry=? ";
        jdbcTemplate.update(sql, delv.getCode(), delv.getName(), delv.getDueDate(), delv.getId());

    }

    @Override
    public void deleteDelivery(int id) {
        String sql = "DELETE from dbo.ODLN WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
    }

}
