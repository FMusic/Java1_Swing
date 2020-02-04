package com.fm.model;

import javax.persistence.*;

@Entity
@Table(name = "PatientFees", schema = "dbo", catalog = "Java1_Hospital")
public class PatientFeesEntity {
    private Integer consultingFees;
    private Integer medicineFees;
    private Integer orderedTestsFees;
    private Integer id;

    public PatientFeesEntity(Integer consultingFees, Integer medicineFees, Integer orderedTestsFees){
        this.consultingFees = consultingFees;
        this.medicineFees = medicineFees;
        this.orderedTestsFees = orderedTestsFees;
    }

    public PatientFeesEntity() {
    }

    @Id
    @GeneratedValue
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setMedicineFees(Integer medicineFees) {
        this.medicineFees = medicineFees;
    }

    public void setOrderedTestsFees(Integer orderedTestsFees) {
        this.orderedTestsFees = orderedTestsFees;
    }

    @Basic
    public Integer getConsultingFees() {
        return consultingFees;
    }

    public void setConsultingFees(Integer consultingFees){
        this.consultingFees = consultingFees;
    }

    @Basic
    public Integer getOrderedTestsFees() {
        return orderedTestsFees;
    }

    @Basic
    public Integer getMedicineFees() {
        return medicineFees;
    }
}
