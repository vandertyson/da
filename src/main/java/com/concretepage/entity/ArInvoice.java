package com.concretepage.entity;

import java.util.Date;
import java.util.List;

//ve sau can hien thi them truong gi thi khai bao vao day
public class ArInvoice {

    public ArInvoice() {
    }

    public ArInvoice(int id, String name, String code, int docnum, String contactpersonname, String currency, String saleemployee, String employee, Date docdate, Date duedate, Date taxdate, String address, String shipto, int trasnport, String slpname, String cntname, String emfirstname, String emplastname, String transportname, String ref, List<DeliveryGrid> listItem) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.docnum = docnum;
        this.contactpersonname = contactpersonname;
        this.currency = currency;
        this.saleemployee = saleemployee;
        this.employee = employee;
        this.docdate = docdate;
        this.duedate = duedate;
        this.taxdate = taxdate;
        this.address = address;
        this.shipto = shipto;
        this.trasnport = trasnport;
        this.slpname = slpname;
        this.emfirstname = emfirstname;
        this.emplastname = emplastname;
        this.transportname = transportname;
        this.ref = ref;
        this.listItem = this.listItem;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDocnum() {
        return docnum;
    }

    public void setDocnum(int docnum) {
        this.docnum = docnum;
    }

    public String getContactCode() {
        return contactpersoncode;
    }

    public void setContactCode(String code) {
        this.contactpersoncode = code;
    }

    public String getContactName() {
        return contactpersonname;
    }

    public void setContactName(String contactpersonname) {
        this.contactpersonname = contactpersonname;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSaleEmployee() {
        return saleemployee;
    }

    public void setSaleEmployee(String saleemployee) {
        this.saleemployee = saleemployee;
    }

    public String getSlpname() {
        return slpname;
    }

    public void setSlpname(String slpname) {
        this.slpname = slpname;
    }

    public String getEmfirstname() {
        return emfirstname;
    }

    public void setEmfirstname(String emfirstname) {
        this.emfirstname = emfirstname;
    }

    public String getEmplastname() {
        return emplastname;
    }

    public void setEmplastname(String emplastname) {
        this.emplastname = emplastname;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTransportname() {
        return transportname;
    }

    public void setTransportname(String transportname) {
        this.transportname = transportname;
    }

    private int id;
    private String name;
    private String code;
    private int docnum;
    private String contactpersoncode;
    private String contactpersonname;
    private String currency;
    private String saleemployee;
    private String employee;
    private Date docdate;
    private Date duedate;
    private Date taxdate;
    private String address;
    private String shipto;
    private int trasnport;
    private String slpname;
    private String emfirstname;
    private String emplastname;
    private String transportname;
    private String ref;
    private List<ArGrid> listItem;

    public List<ArGrid> getListItem() {
        return listItem;
    }

    public void setListItem(List<ArGrid> listItem) {
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
