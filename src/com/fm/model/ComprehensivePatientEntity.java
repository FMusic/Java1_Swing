package com.fm.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ComprehensivePatient", schema = "dbo", catalog = "Java1_Hospital")
public class ComprehensivePatientEntity {
    private int idComprPatient;
    private Date dateOfInput;
    private MiniPatientEntity miniPatient;
    private ContactDetailsEntity contactDetails;
    private NextOfKinsEntity nextOfKin;
    private PersonalDetailsEntity personalDetails;
    private ProfessionDetsEntity professionDetails;
    private LifestyleDetsEntity lifestyleDets;
    private BasicComplaintsEntity basicComplaints;
    private ImportantMedicalComplaintsEntity importantMedicalCompl;
    private PatientFeesEntity fees;

    public ComprehensivePatientEntity() {
    }

    public ComprehensivePatientEntity(Date dateOfInput, MiniPatientEntity miniPatient,
                                      ContactDetailsEntity contactDetails, NextOfKinsEntity nextOfKin,
                                      PersonalDetailsEntity personalDetails, ProfessionDetsEntity professionDetails,
                                      LifestyleDetsEntity lifestyleDets, BasicComplaintsEntity basicComplaints,
                                      ImportantMedicalComplaintsEntity importantMedicalCompl) {
        this.dateOfInput = dateOfInput;
        this.miniPatient = miniPatient;
        this.contactDetails = contactDetails;
        this.nextOfKin = nextOfKin;
        this.personalDetails = personalDetails;
        this.professionDetails = professionDetails;
        this.lifestyleDets = lifestyleDets;
        this.basicComplaints = basicComplaints;
        this.importantMedicalCompl = importantMedicalCompl;
    }


    @Id
    @GeneratedValue
    @Column(name = "IDComprPatient", nullable = false)
    public int getIdComprPatient() {
        return idComprPatient;
    }

    public void setIdComprPatient(int idComprPatient) {
        this.idComprPatient = idComprPatient;
    }

    @Basic
    @Column(name = "DateOfInput")
    public Date getDateOfInput() {
        return dateOfInput;
    }

    public void setDateOfInput(Date dateOfInput) {
        this.dateOfInput = dateOfInput;
    }

    @OneToOne
    public MiniPatientEntity getMiniPatient() {
        return miniPatient;
    }

    public void setMiniPatient(MiniPatientEntity miniPatient) {
        this.miniPatient = miniPatient;
    }

    @OneToOne
    public ContactDetailsEntity getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetailsEntity contactDetailsEntity) {
        this.contactDetails = contactDetailsEntity;
    }

    @OneToOne
    public NextOfKinsEntity getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(NextOfKinsEntity nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    @OneToOne
    public PersonalDetailsEntity getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsEntity personalDetailsId) {
        this.personalDetails = personalDetailsId;
    }

    @OneToOne
    public ProfessionDetsEntity getProfessionDets() {
        return professionDetails;
    }

    public void setProfessionDets(ProfessionDetsEntity professionDetails) {
        this.professionDetails = professionDetails;
    }

    @OneToOne
    public LifestyleDetsEntity getLifestyleDets() {
        return lifestyleDets;
    }

    public void setLifestyleDets(LifestyleDetsEntity lifestyleDets) {
        this.lifestyleDets = lifestyleDets;
    }

    @OneToOne
    public BasicComplaintsEntity getBasicComplaints() {
        return basicComplaints;
    }

    public void setBasicComplaints(BasicComplaintsEntity basicComplaints) {
        this.basicComplaints = basicComplaints;
    }

    @OneToOne
    public ImportantMedicalComplaintsEntity getImportantMedicalCompl() {
        return importantMedicalCompl;
    }

    public void setImportantMedicalCompl(ImportantMedicalComplaintsEntity importantMedicalCompl) {
        this.importantMedicalCompl = importantMedicalCompl;
    }

    @OneToOne
    public PatientFeesEntity getFees() {
        return fees;
    }

    public void setFees(PatientFeesEntity fees){
        this.fees = fees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComprehensivePatientEntity that = (ComprehensivePatientEntity) o;
        return idComprPatient == that.idComprPatient &&
                dateOfInput.equals(that.dateOfInput) &&
                miniPatient.equals(that.miniPatient) &&
                contactDetails.equals(that.contactDetails) &&
                nextOfKin.equals(that.nextOfKin) &&
                personalDetails.equals(that.personalDetails) &&
                professionDetails.equals(that.professionDetails) &&
                lifestyleDets.equals(that.lifestyleDets) &&
                basicComplaints.equals(that.basicComplaints) &&
                importantMedicalCompl.equals(that.importantMedicalCompl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComprPatient, dateOfInput, miniPatient, contactDetails, nextOfKin, personalDetails, professionDetails, lifestyleDets, basicComplaints, importantMedicalCompl);
    }

    @Override
    public String toString() {
        return "ComprehensivePatientEntity{" +
                "idComprPatient=" + idComprPatient +
                ", dateOfInput=" + dateOfInput +
                ", miniPatient=" + miniPatient +
                ", contactDetails=" + contactDetails +
                ", nextOfKin=" + nextOfKin +
                ", personalDetails=" + personalDetails +
                ", professionDetails=" + professionDetails +
                ", lifestyleDets=" + lifestyleDets +
                ", basicComplaints=" + basicComplaints +
                ", importantMedicalCompl=" + importantMedicalCompl +
                '}';
    }

    public ComprehensivePatientEntity update(ComprehensivePatientEntity cde){
        this.dateOfInput = cde.getDateOfInput();
        this.miniPatient = cde.getMiniPatient();
        this.contactDetails = cde.getContactDetails();
        this.nextOfKin = cde.getNextOfKin();
        this.personalDetails = cde.getPersonalDetails();
        this.professionDetails = cde.getProfessionDets();
        this.lifestyleDets = cde.getLifestyleDets();
        this.basicComplaints = cde.getBasicComplaints();
        this.importantMedicalCompl = cde.getImportantMedicalCompl();
        return this;
    }
}
