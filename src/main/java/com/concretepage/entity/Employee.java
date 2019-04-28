/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Employee {

    public Employee(int id, String firstname, String lastname, int dept, String sex, String jobtitle, String email, String homecity, Date startdate, Date updatedate, int usersign, String deptname, String bankcode, String bankacount, Date birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dept = dept;
        this.sex = sex;
        this.jobtitle = jobtitle;
        this.email = email;
        this.homecity = homecity;
        this.startdate = startdate;
        this.updatedate = updatedate;
        this.usersign = usersign;
        this.deptname = deptname;
        this.bankcode = bankcode;
        this.bankacount = bankacount;
        this.birthdate = birthdate;
        this.tel = tel;
    }

    private int id;
    private String firstname;
    private String lastname;
    private int dept;
    private String sex;
    private String jobtitle;
    private String email;
    private String homecity;
    private Date startdate;
    private Date updatedate;
    private int usersign;
    private String deptname;
    private String bankcode;
    private String bankacount;
    private Date birthdate;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getBankacount() {
        return bankacount;
    }

    public void setBankacount(String bankacount) {
        this.bankacount = bankacount;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public int getUsersign() {
        return usersign;
    }

    public void setUsersign(int usersign) {
        this.usersign = usersign;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomecity() {
        return homecity;
    }

    public void setHomecity(String homecity) {
        this.homecity = homecity;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public Employee() {
    }

}
