package com.concretepage.entity;

import java.util.Date;
import java.util.List;

//ve sau can hien thi them truong gi thi khai bao vao day
public class Delivery {

    public Delivery() {
    }

    public Delivery(int id, int series, String name, String code, String contactpersonname,
            String contactpersoncode, String saleemployee, String employee,
            Date docdate, Date duedate, Date taxdate,
            String address, String shipto, int trasnport) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.employee = employee;
        this.docdate = docdate;
        this.duedate = duedate;
        this.taxdate = taxdate;
        this.address = address;
        this.shipto = shipto;
        this.trasnport = trasnport;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private int id;
    private String name;
    private String code;
    private String employee;
    private Date docdate;
    private Date duedate;
    private Date taxdate;
    private String address;
    private String shipto;
    private int trasnport;
    private int docnum;

    public int getDocnum() {
        return docnum;
    }

    public void setDocnum(int docnum) {
        this.docnum = docnum;
    }
    private List<DeliveryGrid> listItem;

    public List<DeliveryGrid> getListItem() {
        return listItem;
    }

    public void setListItem(List<DeliveryGrid> listItem) {
        this.listItem = listItem;
    }

    public int getTrasnport() {
        return trasnport;
    }

    public void setTrasnport(int trasnport) {
        this.trasnport = trasnport;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getDocDate() {
        return docdate;
    }

    public void setDocDate(Date docdate) {
        this.docdate = docdate;
    }

    public Date getDueDate() {
        return duedate;
    }

    public void setDueDate(Date duedate) {
        this.duedate = duedate;
    }

    public Date getTaxDate() {
        return taxdate;
    }

    public void setTaxDate(Date taxdate) {
        this.taxdate = taxdate;
    }

}
