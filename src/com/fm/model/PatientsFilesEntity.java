package com.fm.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "PatientsFiles", schema = "dbo", catalog = "Java1_Hospital")
public class PatientsFilesEntity {
    private int idFile;
    private MiniPatientEntity patient;
    private Date date;
    private StaffEntity doctor;
    private String text;

    public PatientsFilesEntity() {
    }
    public PatientsFilesEntity(MiniPatientEntity patient, Date date, StaffEntity doctor, String text) {
        this.patient = patient;
        this.date = date;
        this.doctor = doctor;
        this.text = text;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDFile", nullable = false)
    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    @OneToOne
    public MiniPatientEntity getPatient() {
        return patient;
    }

    public void setPatient(MiniPatientEntity patientId) {
        this.patient = patientId;
    }

    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    public StaffEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(StaffEntity doctor) {
        this.doctor = doctor;
    }

    @Basic
    @Column(name = "Text", length = 400)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientsFilesEntity that = (PatientsFilesEntity) o;
        return idFile == that.idFile &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(date, that.date) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(text, that.text);
    }

    @Override
    public String toString() {
        return date.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFile, patient, date, doctor, text);
    }
}
