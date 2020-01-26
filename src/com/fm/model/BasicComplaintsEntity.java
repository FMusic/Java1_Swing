package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BasicComplaints", schema = "dbo", catalog = "Java1_Hospital")
public class BasicComplaintsEntity {
    private int idComplaint;
    private String statementOfComplaint;
    private String historyOfPreviousTreatment;
    private StaffEntity physicianTreated;

    public BasicComplaintsEntity() {
    }
    public BasicComplaintsEntity(String statementOfComplaint, String historyOfPreviousTreatment, StaffEntity physicianTreated) {
        this.statementOfComplaint = statementOfComplaint;
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
        this.physicianTreated = physicianTreated;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDComplaint", nullable = false)
    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    @Basic
    @Column(name = "StatementOfComplaint", length = 300)
    public String getStatementOfComplaint() {
        return statementOfComplaint;
    }

    public void setStatementOfComplaint(String statementOfComplaint) {
        this.statementOfComplaint = statementOfComplaint;
    }

    @Basic
    @Column(name = "HistoryOfPreviousTreatment", length = 500)
    public String getHistoryOfPreviousTreatment() {
        return historyOfPreviousTreatment;
    }

    public void setHistoryOfPreviousTreatment(String historyOfPreviousTreatment) {
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
    }

    @OneToOne
    public StaffEntity getPhysicianTreated() {
        return physicianTreated;
    }

    public void setPhysicianTreated(StaffEntity physicianTreated) {
        this.physicianTreated = physicianTreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicComplaintsEntity that = (BasicComplaintsEntity) o;
        return idComplaint == that.idComplaint &&
                Objects.equals(statementOfComplaint, that.statementOfComplaint) &&
                Objects.equals(historyOfPreviousTreatment, that.historyOfPreviousTreatment) &&
                Objects.equals(physicianTreated, that.physicianTreated);
    }

    @Override
    public String toString() {
        return "BasicComplaintsEntity{" +
                "idComplaint=" + idComplaint +
                ", statementOfComplaint='" + statementOfComplaint + '\'' +
                ", historyOfPreviousTreatment='" + historyOfPreviousTreatment + '\'' +
                ", physicianTreated='" + physicianTreated + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComplaint, statementOfComplaint, historyOfPreviousTreatment, physicianTreated);
    }
}
