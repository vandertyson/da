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
public class Department {

    public Department(int code, String name) {
        super();
        
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;

    public Department() {
        super();
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
}
