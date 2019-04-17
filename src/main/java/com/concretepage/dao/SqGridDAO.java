package com.concretepage.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.SqGrid;
import com.concretepage.rowmapper.SqGridRowMapper;
import com.concretepage.daointerface.ISalesQuotationDAO;
import com.concretepage.daointerface.ISqGridDAO;
@Transactional
@Repository
public class SqGridDAO implements ISqGridDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public SqGrid getSqGridById(int gridID) {
		//Day cai query ong sua o day
		//De y cai RowMapper. ben rowmapper can bao nhieu truong thi o day select bay nhieu truong
		String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,Price,Currency"
                        + "vat,UomCode,TaxCode,LineTotal FROM dbo.QUT1";
		RowMapper<SqGrid> rowMapper = new SqGridRowMapper();
		SqGrid grid = jdbcTemplate.queryForObject(sql, rowMapper, gridID);
		return grid;
	}
	@Override
	public List<SqGrid> getAllSqGrid() {
		String sql = "SELECT DocEntry,LineNum,ItemCode,Dscription,Quantity,Price,Currency,"
                        + "vat,UomCode,TaxCode,LineTotal FROM dbo.QUT1";
		RowMapper<SqGrid> rowMapper = new SqGridRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	
}
