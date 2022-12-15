package com.example.end_semester_homework.entity;

public class User {
    private int id;
    private String account;
    private String password;

    public User() {
    }

    public User(int id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{id = " + id + ", account = " + account + ", password = " + password + "}";
    }
}
