/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class InPayment {

    public InPayment(int docnum, int docentry, String doctype, String code, String name, Date docdate, Date duedate, Date taxdate, double doctotal, String bankcode, String bankacc) {
        super();
        this.docnum = docnum;
        this.docentry = docentry;
        this.doctype = doctype;
        this.code = code;
        this.name = name;
        this.docdate = docdate;
        this.duedate = duedate;
        this.taxdate = taxdate;
        this.doctotal = doctotal;
        this.bankcode = bankcode;
        this.bankacc = bankacc;
    }

    private int docnum;
    private int docentry;
    private String doctype;
    private String code;
    private String name;
    private Date docdate;
    private Date duedate;
    private Date taxdate;
    private double doctotal;
    private String bankcode;
    private String bankacc;

    public InPayment() {
        super();
    }

    public int getDocnum() {
        return docnum;
    }

    public void setDocnum(int docnum) {
        this.docnum = docnum;
    }

    public int getDocentry() {
        return docentry;
    }

    public void setDocentry(int docentry) {
        this.docentry = docentry;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDocdate() {
        return docdate;
    }

    public void setDocdate(Date docdate) {
        this.docdate = docdate;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Date getTaxdate() {
        return taxdate;
    }

    public void setTaxdate(Date taxdate) {
        this.taxdate = taxdate;
    }

    public double getDoctotal() {
        return doctotal;
    }

    public void setDoctotal(double doctotal) {
        this.doctotal = doctotal;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getBankacc() {
        return bankacc;
    }

    public void setBankacc(String bankacc) {
        this.bankacc = bankacc;
    }
    
}
