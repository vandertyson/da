package com.concretepage.entity;

import java.util.Date;
import java.util.List;

//ve sau can hien thi them truong gi thi khai bao vao day
public class SalesQuotation {

    public SalesQuotation() {
    }

    public SalesQuotation(int id, int series, String name, String code, String contactpersonname,
            String contactpersoncode, String currency, String saleemployee, String employee,
            Date docdate, Date duedate, Date taxdate, int docnum) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.contactpersonname = contactpersonname;
        this.contactpersoncode = contactpersoncode;
        this.currency = currency;
        this.saleemployee = saleemployee;
        this.employee = employee;
        this.docdate = docdate;
        this.duedate = duedate;
        this.taxdate = taxdate;
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

    private int id;
    private String name;
    private String code;
    private String contactpersonname;
    private String currency;
    private String saleemployee;
    private String employee;
    private Date docdate;
    private Date duedate;
    private Date taxdate;
    private int docnum;
    private String docstatus;
    private String slpname;
    private String cntname;
    private String emfirstname;
    private String emplastname;
    private String ref;
    private List<SqGrid> listItem;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public String getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(String docstatus) {
        this.docstatus = docstatus;
    }

    public int getDocnum() {
        return docnum;
    }

    public void setDocnum(int docnum) {
        this.docnum = docnum;
    }

    public List<SqGrid> getListItem() {
        return listItem;
    }

    public void setListItem(List<SqGrid> listItem) {
        this.listItem = listItem;
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

    public String getContactCode() {
        return contactpersoncode;
    }

    public void setContactCode(String code) {
        this.contactpersoncode = code;
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

    private String contactpersoncode;
}
