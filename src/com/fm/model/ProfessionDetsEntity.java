package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ProfessionDets", schema = "dbo", catalog = "Java1_Hospital")
public class ProfessionDetsEntity {
    private int idProffesionDetails;
    private String occupation;
    private Integer grossAnnualIncome;

    public ProfessionDetsEntity() {
    }
    public ProfessionDetsEntity(String occupation, int grossAnnualIncome) {
        this.occupation = occupation;
        this.grossAnnualIncome = grossAnnualIncome;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDProffesionDetails", nullable = false)
    public int getIdProffesionDetails() {
        return idProffesionDetails;
    }

    public void setIdProffesionDetails(int idProffesionDetails) {
        this.idProffesionDetails = idProffesionDetails;
    }

    @Basic
    @Column(name = "Occupation", length = 20)
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Basic
    @Column(name = "GrossAnnualIncome")
    public Integer getGrossAnnualIncome() {
        return grossAnnualIncome;
    }

    public void setGrossAnnualIncome(Integer grossAnnualIncome) {
        this.grossAnnualIncome = grossAnnualIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionDetsEntity that = (ProfessionDetsEntity) o;
        return idProffesionDetails == that.idProffesionDetails &&
                Objects.equals(occupation, that.occupation) &&
                Objects.equals(grossAnnualIncome, that.grossAnnualIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProffesionDetails, occupation, grossAnnualIncome);
    }

    @Override
    public String toString() {
        return "ProfessionDetsEntity{" +
                "idProffesionDetails=" + idProffesionDetails +
                ", occupation='" + occupation + '\'' +
                ", grossAnnualIncome=" + grossAnnualIncome +
                '}';
    }
}
