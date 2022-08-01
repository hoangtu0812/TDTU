package model;

import java.sql.Date;

public class Account {
    private String userMail;
    private String password;
    private String name;
    private Date birthday;
    private String phone;
    private String role;
    private int status;
    private String message;

    public Account(String userMail, String password, String name, Date birthday, String phone, String role, int status) {
        this.userMail = userMail;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }
    public Account () {

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

    public boolean validate() {
       if (this.userMail == null || this.userMail.trim().equals("")) {
           this.message = "Email was not set";
           return false;
       }
       if (this.password == null || this.password.trim().equals("")) {
           this.message = "Password was not set";
           return false;
       }
       if(this.birthday == null) {
           this.message = "Birthday was not set";
           return false;
       }
       if(this.name == null || this.name.trim().equals("")) {
           this.message = "Name was not set";
           return false;
       }
       if (this.phone == null || this.phone.trim().equals("")){
           this.message = "Phone was not set";
           return false;
       }
       if (this.role == null || this.role.trim().equals("")) {
           this.message = "Role was not set";
           return false;
       }
       if (!this.userMail.matches(".+@.+\\.[a-z]+")) {
            this.message = "This email address is not valid";
            return false;
       }
       if (this.password.length() < 8) {
           this.message = "Password cannot less then 8 characters long";
           return false;
       }
       return true;
    }
    public String getMessage() {
        return this.message;
    }
}
