package com.concretepage.entity;

//ve sau can hien thi them truong gi thi khai bao vao day
public class Item {

    public Item() {
        super();
    }

    public Item(String code, String name, int group, String vatgroup, Double onhand) {
        super();

        this.name = name;
        this.code = code;
        this.group = group;
        this.vatgroup = vatgroup;
        this.onhand = onhand;
    }
    private String code;
    private String name;
    private int group;
    private String vatgroup;
    private Double onhand;

    public Double getOnhand() {
        return onhand;
    }

    public void setOnhand(Double onhand) {
        this.onhand = onhand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getVatGroup() {
        return vatgroup;
    }

    public void setVatGroup(String vatgroup) {
        this.vatgroup = vatgroup;
    }

}
