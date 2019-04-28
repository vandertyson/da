package com.concretepage.dao;

import com.concretepage.daointerface.IItemDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Item;
import com.concretepage.entity.SalesQuotation;
import com.concretepage.rowmapper.ItemRowMapper;
import com.concretepage.rowmapper.SalesQuotationRowMapper;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Repository
public class ItemDAO implements IItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Item> getAllItem() {
        String sql = "SELECT * FROM view_item";
        RowMapper<Item> rowMapper = new ItemRowMapper();

        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Item> getAllItem(String top) {
        String sql = "SELECT TOP (?) FROM view_item ";
        RowMapper<Item> rowMapper = new ItemRowMapper();

        return this.jdbcTemplate.query(sql, new Object[]{Integer.parseInt(top)}, rowMapper);
    }

    @Override
    public List<Item> getItemWithName(String name) {
        String sql = "SELECT * FROM view_item where ItemName like ?";
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", "%" + name + "%");
        RowMapper<Item> rowMapper = new ItemRowMapper();
        return this.jdbcTemplate.query(sql, new String[]{"%" + name + "%"}, rowMapper);
    }

    @Override
    public void addItem(Item item) {
        String sql = "INSERT INTO dbo.OITM (ItemCode,ItemName,ItmsGrpCod,OnHand,InvntryUom,vat,CreateDate) "
                + "values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, item.getCode(), item.getName(), item.getGroup(),
                item.getOnhand(), item.getUomcode(), item.getVat(), item.getCreatedate());
    }

    @Override
    public void updateItem(Item item) {
        String sql = "UPDATE dbo.OITM SET ItemName = ?, ItmsGrpCod= ?, vat = ?, OnHand=?, InvntryUom=?,UpdateDate=? "
                + "WHERE ItemCode = ?";
        jdbcTemplate.update(sql, item.getName(), item.getGroup(),
                item.getVat(), item.getOnhand(), item.getUomcode(), item.getUpdatedate(), item.getCode());

    }

    @Override
    public void deleteItem(String code) {
        String sql = "DELETE FROM dbo.OITM where ItemCode = ?";
        jdbcTemplate.update(sql, code);
    }

    @Override
    public Item getItemById(String code) {
        String sql = "select * from view_item where ItemCode = ?";
        RowMapper<Item> rowMapper = new ItemRowMapper();
        Item item = jdbcTemplate.queryForObject(sql, rowMapper, code);
        return item;
    }
}
