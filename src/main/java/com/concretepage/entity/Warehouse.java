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
public class Warehouse {

    public Warehouse(String whscode, String whsname, String lock, String objtype, Date createdate) {
        super();
        this.whscode = whscode;
        this.whsname = whsname;
        this.lock = lock;
        this.objtype = objtype;
        this.createdate = createdate;
    }

    private String whscode;
    private String whsname;
    private String lock;
    private String objtype;
    private Date createdate;

    public Warehouse() {
        super();
    }

    public String getWhscode() {
        return whscode;
    }

    public void setWhscode(String whscode) {
        this.whscode = whscode;
    }

    public String getWhsname() {
        return whsname;
    }

    public void setWhsname(String whsname) {
        this.whsname = whsname;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getObjtype() {
        return objtype;
    }

    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}
