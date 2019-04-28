package com.concretepage.entity;

import java.util.Date;

//ve sau can hien thi them truong gi thi khai bao vao day
public class SoGrid {

    public SoGrid() {
    }

    public SoGrid(int id, String itemcode, String description, Double quantity,
            Double price, Double total, String currency, String vatgroup, String taxcode, String warehouse
    ) {
        super();
        this.id = id;
        this.itemcode = itemcode;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.warehouse = warehouse;
        this.vat = vat;
        this.discount = discount;
        this.total = total;
        this.discount = discount;
        this.uomcode = uomcode;
        this.openqty = openqty;

    }

    public int getLinenum() {
        return linenum;
    }

    public void setLinenum(int linenum) {
        this.linenum = linenum;
    }

    private int id;
    private int linenum;
    private String itemcode;
    private String description;
    private Double quantity;
    private Double price;
    private Double total;
    private String currency;
    private int vat;
    private int discount;
    private String warehouse;
    private String uomcode;
    private Double openqty;

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Double getOpenqty() {
        return openqty;
    }

    public void setOpenqty(Double openqty) {
        this.openqty = openqty;
    }

    public String getUomcode() {
        return uomcode;
    }

    public void setUomcode(String uomcode) {
        this.uomcode = uomcode;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
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

}
