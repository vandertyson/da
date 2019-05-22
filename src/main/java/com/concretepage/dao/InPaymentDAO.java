/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.dao;

import com.concretepage.daointerface.IInPaymentDAO;
import com.concretepage.entity.InPayment;
import com.concretepage.rowmapper.InPaymentRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class InPaymentDAO implements IInPaymentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<InPayment> getAllPayment() {
        String sql = "select * from dbo.OCRT";
        RowMapper<InPayment> rowMapper = new InPaymentRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public InPayment getPaymentById(int payID) {
        String sql = "select * from dbo.OCRT where DocEntry = ?";
        RowMapper<InPayment> rowMapper = new InPaymentRowMapper();
        InPayment pay = jdbcTemplate.queryForObject(sql, rowMapper, payID);
        return pay;
    }

    @Override
    public void deletePayment(int id) {
        String sql = "DELETE from dbo.OCRT WHERE DocEntry = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addPayment(InPayment pay) {
        String sql1ll = "Select max(DocEntry) from dbo.OCRT";
        Long newDocEntry = jdbcTemplate.queryForObject(sql1ll, Long.class);
        String sql1 = "Select max(DocNum) from dbo.OCRT";
        Long newDocNum = jdbcTemplate.queryForObject(sql1, Long.class);
        String sql_insert = "INSERT INTO dbo.OCRT (DocEntry,DocNum,CardCode,CardName,CntctCode,DocType,DocDate,DocDueDate,TaxDate,"
                + "DocTotal,BankCode,BankAcct) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql_insert, newDocEntry + 1, newDocNum + 1, pay.getCode(),pay.getName(),pay.getContactCode(),pay.getDoctype(),
                pay.getDocdate(),pay.getDuedate(),pay.getTaxdate(),pay.getDoctotal(),pay.getBankcode(),pay.getBankacc());
    }

    @Override
    public void updatePayment(InPayment pay) {
        String sql_pay = "UPDATE dbo.OCRT SET DocTotal = ?, DocDueDate = ?, DocType = ?, BankCode = ?, BankAcct = ?"
                + " WHERE DocEntry = ?";
        jdbcTemplate.update(sql_pay, pay.getDoctotal(), pay.getDuedate(), pay.getDoctype(),
                pay.getBankcode(), pay.getBankacc(), pay.getDocentry());
    }

}
