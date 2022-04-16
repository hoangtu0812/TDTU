package model;


import java.sql.Date;

public class Payment {
    private String userMail;
    private int wallet;
    private int userPay;
    private Date payTime;
    private String tcode;
    private int status;
    private int pracCalId;

    public Payment(String userMail, int wallet, int userPay, Date payTime, String tcode, int status, int pracCalId) {
        this.userMail = userMail;
        this.wallet = wallet;
        this.userPay = userPay;
        this.payTime = payTime;
        this.tcode = tcode;
        this.status = status;
        this.pracCalId = pracCalId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getUserPay() {
        return userPay;
    }

    public void setUserPay(int userPay) {
        this.userPay = userPay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPracCalId() {
        return pracCalId;
    }

    public void setPracCalId(int pracCalId) {
        this.pracCalId = pracCalId;
    }
}
