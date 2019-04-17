package com.concretepage.entity;

import java.util.Date;

//ve sau can hien thi them truong gi thi khai bao vao day
public class SqGrid {

    public SqGrid() {
    }

    public SqGrid(int id, String itemcode, String description, Double quantity,
            Double price, Double total, String currency, String vatgroup, String taxcode
    ) {
        super();
        this.id = id;
        this.itemcode = itemcode;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.vat = vat;
        this.taxcode = taxcode;

    }

    private int id;
    private String itemcode;
    private String description;
    private Double quantity;
    private Double price;
    private Double total;
    private String currency;
    private int vat;

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }
    private String taxcode;
    private String uomcode;
    private int linenum;

    public int getLinenum() {
        return linenum;
    }

    public void setLinenum(int linenum) {
        this.linenum = linenum;
    }

    public String getUomcode() {
        return uomcode;
    }

    public void setUomcode(String uomcode) {
        this.uomcode = uomcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

}
