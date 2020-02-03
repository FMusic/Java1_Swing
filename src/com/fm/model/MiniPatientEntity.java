package com.fm.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MiniPatient", schema = "dbo", catalog = "Java1_Hospital")
public class MiniPatientEntity {
    private Date dateOfInput;
    private int idPatient;
    private String firstName;
    private String middleName;
    private String lastName;
    private String sex;
    private Date dateOfBirth;
    private String briefStatement;
    private String tel1;
    private String tel2;
    private NextOfKinsEntity nextOfKin;
    private List<PatientsFilesEntity> listOfFiles;
    private StaffEntity doctor;

    public MiniPatientEntity() {
    }
    public MiniPatientEntity(Date dateOfInput, String firstName, String middleName, String lastName, String sex, Date dateOfBirth, String briefStatement,
                             String tel1, String tel2, NextOfKinsEntity nextOfKin) {
        this.dateOfBirth = dateOfBirth;
        this.dateOfInput = dateOfInput;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.briefStatement = briefStatement;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.nextOfKin = nextOfKin;
    }

    @Basic
    @Column(name = "DateOfInput")
    public Date getDateOfInput() {
        return dateOfInput;
    }

    public void setDateOfInput(Date dateOfInput) {
        this.dateOfInput = dateOfInput;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDPatient", nullable = false)
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    @Basic
    @Column(name = "FirstName", length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "MiddleName", length = 20)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "LastName", length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Sex", length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "DateOfBirth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "BriefStatement", length = 200)
    public String getBriefStatement() {
        return briefStatement;
    }

    public void setBriefStatement(String briefStatement) {
        this.briefStatement = briefStatement;
    }

    @Basic
    @Column(name = "Tel1", length = 10)
    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    @Basic
    @Column(name = "Tel2", length = 10)
    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    @ManyToOne
    public NextOfKinsEntity getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(NextOfKinsEntity nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiniPatientEntity that = (MiniPatientEntity) o;
        return idPatient == that.idPatient &&
                Objects.equals(dateOfInput, that.dateOfInput) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(briefStatement, that.briefStatement) &&
                Objects.equals(tel1, that.tel1) &&
                Objects.equals(tel2, that.tel2) &&
                Objects.equals(nextOfKin, that.nextOfKin);
    }

    @Override
    public String toString() {
        return firstName + ' ' + middleName + ' ' + lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfInput, idPatient, firstName, middleName, lastName, sex, dateOfBirth, briefStatement, tel1, tel2, nextOfKin);
    }

    @OneToMany
    public List<PatientsFilesEntity> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(List<PatientsFilesEntity> listOfFiles) {
        this.listOfFiles = listOfFiles;
    }

    @OneToOne
    public StaffEntity getDoctorForPatient(){
        return doctor;
    }

    public void setDoctorForPatient(StaffEntity doctor){
        this.doctor = doctor;
    }
}
