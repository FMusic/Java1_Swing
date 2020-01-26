package com.fm.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table
public class Calendar {
    private int eventId;
    private ComprehensivePatientEntity patient;
    private StaffEntity staff;
    private Date date;
    private Time time;

    public Calendar() {
    }

    public Calendar(ComprehensivePatientEntity patient, StaffEntity staff, Date date, Time time) {
        this.patient = patient;
        this.staff = staff;
        this.date = date;
        this.time = time;
    }

    @Id
    @Column
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @ManyToOne
    public ComprehensivePatientEntity getPatient() {
        return patient;
    }

    public void setPatient(ComprehensivePatientEntity patient) {
        this.patient = patient;
    }

    @ManyToOne
    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }

    @Column
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return patient.equals(calendar.patient) &&
                staff.equals(calendar.staff) &&
                date.equals(calendar.date) &&
                time.equals(calendar.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, staff, date, time);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "patient=" + patient +
                ", staff=" + staff +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
