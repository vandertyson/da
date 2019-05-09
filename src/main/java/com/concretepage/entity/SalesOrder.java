package com.concretepage.entity;

import java.util.Date;
import java.util.List;

//ve sau can hien thi them truong gi thi khai bao vao day
public class SalesOrder {

    public SalesOrder(int id, int series, String name, String code, String contactpersonname,
            String currency, String saleemployee, String employee,
            Date docdate, Date duedate, Date taxdate,
            String address, String shipto, String billto, String add, int transport) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.contactpersonname = contactpersonname;
        this.currency = currency;
        this.saleemployee = saleemployee;
        this.employee = employee;
        this.docdate = docdate;
        this.duedate = duedate;
        this.taxdate = taxdate;
        this.address = address;
        this.shipto = shipto;
        this.transport = transport;
        
    }

    public SalesOrder() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContactName() {
        return contactpersonname;
    }

    public void setContactName(String contactpersonname) {
        this.contactpersonname = contactpersonname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocnum() {
        return docnum;
    }

    public void setDocnum(int docnum) {
        this.docnum = docnum;
    }

    private int id;
    private String name;
    private String code;
    private int docnum;
    private String contactpersonname;
    private String currency;
    private String saleemployee;
    private String employee;
    private Date docdate;
    private Date duedate;
    private Date taxdate;
    private String address;
    private String shipto;
    private int transport;
    private String slpname;
    private String cntname;
    private String emfirstname;
    private String emplastname;
    private String transportname;
    private String ref;
    private String docstatus;
    private List<SoGrid> listItem;
    private List<SalesQuotation> listQuotation;

    public String getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(String docstatus) {
        this.docstatus = docstatus;
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

    public String getSlpname() {
        return slpname;
    }

    public void setSlpname(String slpname) {
        this.slpname = slpname;
    }

    public String getCntname() {
        return cntname;
    }

    public void setCntname(String cntname) {
        this.cntname = cntname;
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

    public List<SalesQuotation> getListQuotation() {
        return listQuotation;
    }

    public void setListQuotation(List<SalesQuotation> listQuotation) {
        this.listQuotation = listQuotation;
    }

    public List<SoGrid> getListItem() {
        return listItem;
    }

    public void setListItem(List<SoGrid> listItem) {
        this.listItem = listItem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }

    public int getTrasnport() {
        return transport;
    }

    public void setTrasnport(int trasnport) {
        this.transport = trasnport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
