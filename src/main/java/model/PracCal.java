package model;

import java.sql.Date;

public class PracCal {
    private int pracCalId;
    private Date startDate;
    private Date endDate;
    private int memberCount;
    private int calStatus;
    private String coachName;
    private String managerName;

    public PracCal(int pracCalId, Date startDate, Date endDate, int memberCount, int calStatus, String coachName, String managerName) {
        this.pracCalId = pracCalId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.memberCount = memberCount;
        this.calStatus = calStatus;
        this.coachName = coachName;
        this.managerName = managerName;
    }

    public int getPracCalId() {
        return pracCalId;
    }

    public void setPracCalId(int pracCalId) {
        this.pracCalId = pracCalId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getCalStatus() {
        return calStatus;
    }

    public void setCalStatus(int calStatus) {
        this.calStatus = calStatus;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
