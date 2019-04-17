package com.concretepage.entity;

import java.util.Date;

//ve sau can hien thi them truong gi thi khai bao vao day
public class ArGrid {

    public ArGrid() {
    }

    public ArGrid(int id, String itemcode, String description, Double quantity,
            Double price, Double total, String currency, String vatgroup, String taxcode, String warehouse
    ) {
        super();
        this.id = id;
        this.itemcode = itemcode;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.vatgroup = vatgroup;
        this.taxcode = taxcode;
        this.warehouse = warehouse;

    }

    private int id;
    private String itemcode;
    private String description;
    private Double quantity;
    private Double price;
    private Double total;
    private String currency;
    private String vatgroup;
    private String taxcode;
    private String warehouse;
    private String uomcode;

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

    public String getVatgroup() {
        return vatgroup;
    }

    public void setVatgroup(String vatgroup) {
        this.vatgroup = vatgroup;
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

}
