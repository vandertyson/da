package com.concretepage.entity;

//ve sau can hien thi them truong gi thi khai bao vao day
public class Users {

    public Users() {
        super();
    }

    public Users(int id, String password) {
        super();

        this.id = id;
        this.password = password;
    }
    private int id;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
