package model;

import java.sql.Date;

public class User {
    private String userMail;
    private String password;
    private String name;
    private Date birthday;
    private String phone;
    private String role;
    private int status;

    public User(String userMail, String password, String name, Date birthday, String phone, String role, int status) {
        this.userMail = userMail;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
