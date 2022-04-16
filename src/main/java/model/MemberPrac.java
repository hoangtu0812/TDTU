package model;

public class MemberPrac {
    private String userMail;
    private int calDetailId;
    private int memberStatus;

    public MemberPrac(String userMail, int calDetailId, int memberStatus) {
        this.userMail = userMail;
        this.calDetailId = calDetailId;
        this.memberStatus = memberStatus;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getCalDetailId() {
        return calDetailId;
    }

    public void setCalDetailId(int calDetailId) {
        this.calDetailId = calDetailId;
    }

    public int getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(int memberStatus) {
        this.memberStatus = memberStatus;
    }
}
