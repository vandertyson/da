/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.rowmapper;

import com.concretepage.entity.ItemGroup;
import com.concretepage.entity.Transport;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Admin
 */
public class ItemGroupRowMapper implements RowMapper<ItemGroup> {

    @Override
    public ItemGroup mapRow(ResultSet row, int rowNum) throws SQLException {
        ItemGroup group = new ItemGroup();
        group.setGroupcode(row.getInt("ItmsGrpCod"));
        group.setGroupname(row.getString("ItmsGrpNam"));
        return group;
    }

}
