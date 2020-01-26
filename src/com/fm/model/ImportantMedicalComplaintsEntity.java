package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ImportantMedicalComplaints", schema = "dbo", catalog = "Java1_Hospital")
public class ImportantMedicalComplaintsEntity {
    private int idMedicalComplaints;
    private String diabetic;
    private String hypertensive;
    private String cardiacCondition;
    private String respiratoryCondition;
    private String digestiveCondition;
    private String orthopedicCondition;
    private String muscularCondition;
    private String neurologicalCondition;
    private String allergies;
    private String adverseReactions;
    private String majorSurgeries;

    public ImportantMedicalComplaintsEntity() {
    }

    public ImportantMedicalComplaintsEntity(String diabetic, String hypertensive, String cardiacCondition, String respiratoryCondition, String digestiveCondition,
                                            String orthopedicCondition, String muscularCondition, String neurologicalCondition, String allergies,
                                            String adverseReactions, String majorSurgeries) {
        this.diabetic = diabetic;
        this.hypertensive = hypertensive;
        this.cardiacCondition = cardiacCondition;
        this.respiratoryCondition = respiratoryCondition;
        this.digestiveCondition = digestiveCondition;
        this.orthopedicCondition = orthopedicCondition;
        this.muscularCondition = muscularCondition;
        this.neurologicalCondition = neurologicalCondition;
        this.allergies = allergies;
        this.adverseReactions = adverseReactions;
        this.majorSurgeries = majorSurgeries;
    }


    @Id
    @GeneratedValue
    @Column(name = "IDMedicalComplaints", nullable = false)
    public int getIdMedicalComplaints() {
        return idMedicalComplaints;
    }

    public void setIdMedicalComplaints(int idMedicalComplaints) {
        this.idMedicalComplaints = idMedicalComplaints;
    }

    @Basic
    @Column(name = "Diabetic", length = 10)
    public String getDiabetic() {
        return diabetic;
    }

    public void setDiabetic(String diabetic) {
        this.diabetic = diabetic;
    }

    @Basic
    @Column(name = "Hypertensive", length = 10)
    public String getHypertensive() {
        return hypertensive;
    }

    public void setHypertensive(String hypertensive) {
        this.hypertensive = hypertensive;
    }

    @Basic
    @Column(name = "CardiacCondition", length = 30)
    public String getCardiacCondition() {
        return cardiacCondition;
    }

    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    @Basic
    @Column(name = "RespiratoryCondition", length = 20)
    public String getRespiratoryCondition() {
        return respiratoryCondition;
    }

    public void setRespiratoryCondition(String respiratoryCondition) {
        this.respiratoryCondition = respiratoryCondition;
    }

    @Basic
    @Column(name = "DigestiveCondition", length = 20)
    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    @Basic
    @Column(name = "OrthopedicCondition", length = 20)
    public String getOrthopedicCondition() {
        return orthopedicCondition;
    }

    public void setOrthopedicCondition(String orthopedicCondition) {
        this.orthopedicCondition = orthopedicCondition;
    }

    @Basic
    @Column(name = "MuscularCondition", length = 20)
    public String getMuscularCondition() {
        return muscularCondition;
    }

    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    @Basic
    @Column(name = "NeurologicalCondition", length = 20)
    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }

    @Basic
    @Column(name = "Allergies", length = 220)
    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Basic
    @Column(name = "AdverseReactions", length = 20)
    public String getAdverseReactions() {
        return adverseReactions;
    }

    public void setAdverseReactions(String adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    @Basic
    @Column(name = "MajorSurgeries", length = 200)
    public String getMajorSurgeries() {
        return majorSurgeries;
    }

    public void setMajorSurgeries(String majorSurgeries) {
        this.majorSurgeries = majorSurgeries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportantMedicalComplaintsEntity that = (ImportantMedicalComplaintsEntity) o;
        return idMedicalComplaints == that.idMedicalComplaints &&
                Objects.equals(diabetic, that.diabetic) &&
                Objects.equals(hypertensive, that.hypertensive) &&
                Objects.equals(cardiacCondition, that.cardiacCondition) &&
                Objects.equals(respiratoryCondition, that.respiratoryCondition) &&
                Objects.equals(digestiveCondition, that.digestiveCondition) &&
                Objects.equals(orthopedicCondition, that.orthopedicCondition) &&
                Objects.equals(muscularCondition, that.muscularCondition) &&
                Objects.equals(neurologicalCondition, that.neurologicalCondition) &&
                Objects.equals(allergies, that.allergies) &&
                Objects.equals(adverseReactions, that.adverseReactions) &&
                Objects.equals(majorSurgeries, that.majorSurgeries);
    }

    @Override
    public String toString() {
        return "ImportantMedicalComplaintsEntity{" +
                "idMedicalComplaints=" + idMedicalComplaints +
                ", diabetic='" + diabetic + '\'' +
                ", hypertensive='" + hypertensive + '\'' +
                ", cardiacCondition='" + cardiacCondition + '\'' +
                ", respiratoryCondition='" + respiratoryCondition + '\'' +
                ", digestiveCondition='" + digestiveCondition + '\'' +
                ", orthopedicCondition='" + orthopedicCondition + '\'' +
                ", muscularCondition='" + muscularCondition + '\'' +
                ", neurologicalCondition='" + neurologicalCondition + '\'' +
                ", allergies='" + allergies + '\'' +
                ", adverseReactions='" + adverseReactions + '\'' +
                ", majorSurgeries='" + majorSurgeries + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedicalComplaints, diabetic, hypertensive, cardiacCondition, respiratoryCondition, digestiveCondition, orthopedicCondition, muscularCondition, neurologicalCondition, allergies, adverseReactions, majorSurgeries);
    }
}
