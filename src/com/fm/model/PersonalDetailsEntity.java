package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PersonalDetails", schema = "dbo", catalog = "Java1_Hospital")
public class PersonalDetailsEntity {
    private int idPersonalDetails;
    private String maritalStatus;
    private Integer noOfDependents;
    private Integer height;
    private Integer weight;
    private String bloodType;

    public PersonalDetailsEntity() {
    }
    public PersonalDetailsEntity(String maritalStatus, int noOfDependents, int height, int weight, String bloodType) {
        this.maritalStatus = maritalStatus;
        this.noOfDependents = noOfDependents;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDPersonalDetails", nullable = false)
    public int getIdPersonalDetails() {
        return idPersonalDetails;
    }

    public void setIdPersonalDetails(int idPersonalDetails) {
        this.idPersonalDetails = idPersonalDetails;
    }

    @Basic
    @Column(name = "MaritalStatus", length = 10)
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Basic
    @Column(name = "NoOfDependents")
    public Integer getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(Integer noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    @Basic
    @Column(name = "Height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "Weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "BloodType", length = 5)
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "PersonalDetailsEntity{" +
                "idPersonalDetails=" + idPersonalDetails +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", noOfDependents=" + noOfDependents +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalDetailsEntity that = (PersonalDetailsEntity) o;
        return idPersonalDetails == that.idPersonalDetails &&
                Objects.equals(maritalStatus, that.maritalStatus) &&
                Objects.equals(noOfDependents, that.noOfDependents) &&
                Objects.equals(height, that.height) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(bloodType, that.bloodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonalDetails, maritalStatus, noOfDependents, height, weight, bloodType);
    }
}
