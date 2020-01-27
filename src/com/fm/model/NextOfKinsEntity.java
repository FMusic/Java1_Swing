package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "NextOfKins", schema = "dbo", catalog = "Java1_Hospital")
public class NextOfKinsEntity {
    private int idNextOfKin;
    private String firstName;
    private String middleName;
    private String lastName;
    private String relationship;
    private ContactDetailsEntity contactDetails;

    public NextOfKinsEntity(){

    }
    public NextOfKinsEntity(ContactDetailsEntity contactDetails, String firstName, String middleName, String lastName, String relationship){
        this.contactDetails = contactDetails;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.relationship = relationship;

    }

    @Id
    @GeneratedValue
    @Column(name = "IDNextOfKin", nullable = false)
    public int getIdNextOfKin() {
        return idNextOfKin;
    }

    public void setIdNextOfKin(int idNextOfKin) {
        this.idNextOfKin = idNextOfKin;
    }

    @Basic
    @Column(name = "FirstName", length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "MiddleName", length = 30)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "LastName", length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Relationship", length = 25)
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @OneToOne
    public ContactDetailsEntity getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetailsEntity contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NextOfKinsEntity that = (NextOfKinsEntity) o;
        return idNextOfKin == that.idNextOfKin &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(relationship, that.relationship) &&
                Objects.equals(contactDetails, that.contactDetails);
    }

    @Override
    public String toString() {
        return "NextOfKinsEntity{" +
                "idNextOfKin=" + idNextOfKin +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", relationship='" + relationship + '\'' +
                ", contactDetailsId=" + contactDetails +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNextOfKin, firstName, middleName, lastName, relationship, contactDetails);
    }
}
