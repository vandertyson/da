package com.concretepage.dao;

import com.concretepage.daointerface.IItemDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Item;
import com.concretepage.rowmapper.ItemRowMapper;

@Transactional
@Repository
public class ItemDAO implements IItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Item> getAllItem() {
        String sql = "SELECT ItemCode,ItemName,ItmsGrpCod,VatGourpSa,OnHand FROM dbo.OITM";
        RowMapper<Item> rowMapper = new ItemRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Item> getAllItem(String top) {
        String sql = "SELECT TOP (?) ItemCode,ItemName,ItmsGrpCod,VatGourpSa,OnHand FROM dbo.OITM ";
        RowMapper<Item> rowMapper = new ItemRowMapper();
        return this.jdbcTemplate.query(sql, new Object[]{Integer.parseInt(top)}, rowMapper);
    }

    @Override
    public List<Item> getItemWithName(String name) {
        String sql = "SELECT ItemCode,ItemName,ItmsGrpCod,VatGourpSa,OnHand "
                + "FROM dbo.OITM where ItemName = ? ";
        RowMapper<Item> rowMapper = new ItemRowMapper();
        return this.jdbcTemplate.query(sql, new Object[]{name}, rowMapper);
    }

    @Override
    public void addItem(Item item) {
        String sql = "INSERT INTO dbo.OITM (ItemCode,ItemName,ItmsGrpCod,VatGourpSa,OnHand) "
                + "values (?,?,?,?,?)";
        jdbcTemplate.update(sql, item.getCode(), item.getName(), item.getGroup(),
                item.getVatGroup(), item.getOnhand());
    }

    @Override
    public void updateItem(Item item) {
        String sql = "UPDATE dbo.OITM SET ItemName = ?, ItmsGrpCod= ?, VatGourpSa = ?, OnHand=? "
                + "WHERE ItemCode = ?";
        jdbcTemplate.update(sql, item.getName(), item.getGroup(),
                item.getVatGroup(), item.getOnhand(), item.getCode());

    }

    @Override
    public void deleteItem(String code) {
        String sql = "DELETE FROM dbo.OITM where ItemCode = ?";
        jdbcTemplate.update(sql, code);
    }
}
