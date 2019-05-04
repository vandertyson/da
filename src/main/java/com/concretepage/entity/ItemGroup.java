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
public class ItemGroup {

    public ItemGroup(int groupcode, String groupname) {
        super();
        this.groupcode = groupcode;
        this.groupname = groupname;
    }

    private int groupcode;
    private String groupname;

    public ItemGroup() {
        super();
    }

    public int getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(int groupcode) {
        this.groupcode = groupcode;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

}
