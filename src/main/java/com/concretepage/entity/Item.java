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
        this.onhand = onhand;
    }
    private String code;
    private String name;
    private int group;
    private Double onhand;
    private String uomcode;
    private String groupname;
    private int vat;

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUomcode() {
        return uomcode;
    }

    public void setUomcode(String uomcode) {
        this.uomcode = uomcode;
    }

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

}
