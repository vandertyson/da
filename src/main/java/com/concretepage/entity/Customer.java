package com.concretepage.entity;

//ve sau can hien thi them truong gi thi khai bao vao day
import com.google.gson.Gson;

public class Customer {

    public Customer() {
        super();
    }

    private String name;
    private String code;
    private String contactperson;
    private String email;
    private String fax;
    private String phone1;
    private String phone2;
    private int slpcode;

    public int getSlpcode() {
        return slpcode;
    }

    public void setSlpcode(int slpcode) {
        this.slpcode = slpcode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public static void main(String[] args) {
        Customer cust = new Customer();
        Gson gson = new Gson();
        System.out.println(gson.toJson(cust));
    }
}
