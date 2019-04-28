package com.concretepage.entity;

//ve sau can hien thi them truong gi thi khai bao vao day
import com.google.gson.Gson;
import java.util.Date;

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
    private Date createdate;
    private Date updatedate;
    private int usersign;

    public Customer(String name, String code, String contactperson, String email, String fax, String phone1, String phone2, int slpcode, Date createdate, Date updatedate, int usersign) {
        this.name = name;
        this.code = code;
        this.contactperson = contactperson;
        this.email = email;
        this.fax = fax;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.slpcode = slpcode;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.usersign = usersign;
    }

    public int getUsersign() {
        return usersign;
    }

    public void setUsersign(int usersign) {
        this.usersign = usersign;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

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
