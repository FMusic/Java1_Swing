package com.fm.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Staff", schema = "dbo", catalog = "Java1_Hospital")
public class StaffEntity {
    private int idEmployee;
    private String name;
    private String surname;
    private TypesEntity type;
    private Boolean available;
    private List<MiniPatientEntity> patients;

    public StaffEntity() {
    }
    public StaffEntity(String name, String surname, TypesEntity typesEntity, boolean available) {
        this.name = name;
        this.surname = surname;
        this.type = typesEntity;
        this.available = available;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDEmployee", nullable = false)
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Basic
    @Column(name = "Name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Surname", length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToOne
    public TypesEntity getType() {
        return type;
    }

    public void setType(TypesEntity type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Available")
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return idEmployee == that.idEmployee &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(type, that.type) &&
                Objects.equals(available, that.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, name, surname, type, available);
    }

    @Override
    public String toString() {
        if (this.getType().equals(new TypesEntity("Doctor")) || this.getType().equals(new TypesEntity("dr")))
            return "Dr." + name + " " + surname;
        return name + " " + surname;
    }

    @OneToMany
    public List<MiniPatientEntity> getPatients() {
        return patients;
    }

    public void setPatients(List<MiniPatientEntity> patients){
        this.patients = patients;
    }
}
