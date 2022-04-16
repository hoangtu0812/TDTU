package model;

import java.sql.Date;
import java.sql.Time;

public class CalendarDetail {
    private int pracCalId;
    private int calDetailId;
    private Date pracDate;
    private Time startTime;
    private Time endTime;

    public CalendarDetail(int pracCalId, int calDetailId, Date pracDate, Time startTime, Time endTime) {
        this.pracCalId = pracCalId;
        this.calDetailId = calDetailId;
        this.pracDate = pracDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getPracCalId() {
        return pracCalId;
    }

    public void setPracCalId(int pracCalId) {
        this.pracCalId = pracCalId;
    }

    public int getCalDetailId() {
        return calDetailId;
    }

    public void setCalDetailId(int calDetailId) {
        this.calDetailId = calDetailId;
    }

    public Date getPracDate() {
        return pracDate;
    }

    public void setPracDate(Date pracDate) {
        this.pracDate = pracDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
