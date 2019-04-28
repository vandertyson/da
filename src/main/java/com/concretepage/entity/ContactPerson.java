/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.entity;

/**
 *
 * @author Admin
 */
public class ContactPerson {

    private int code;
    private String name;
    private String position;

    public ContactPerson(int code, String name, String position, String phone, String email) {
        this.code = code;
        this.name = name;
        this.position = position;

    }

    public ContactPerson() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
