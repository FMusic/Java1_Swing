package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ContactDetails", schema = "dbo", catalog = "Java1_Hospital")
public class ContactDetailsEntity {
    private int idContactDetails;
    private AddressInfoEntity presentAddress;
    private AddressInfoEntity permanentAddress;
    private String telephoneWork;
    private String telephoneHome;
    private String mobile;
    private String pager;
    private String fax;
    private String email;

    public ContactDetailsEntity() {
    }

    public ContactDetailsEntity(AddressInfoEntity presentAddress, AddressInfoEntity permanentAddress, String telephoneHome, String telephoneWork,
                                String mobile, String pager, String fax, String email){
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.telephoneHome = telephoneHome;
        this.telephoneWork = telephoneWork;
        this.mobile = mobile;
        this.pager = pager;
        this.fax = fax;
        this.email = email;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDContactDetails", nullable = false)
    public int getIdContactDetails() {
        return idContactDetails;
    }

    public void setIdContactDetails(int idContactDetails) {
        this.idContactDetails = idContactDetails;
    }

    @ManyToOne
    public AddressInfoEntity getPresentAddressId() {
        return presentAddress;
    }

    public void setPresentAddressId(AddressInfoEntity presentAddressId) {
        this.presentAddress = presentAddressId;
    }

    @ManyToOne
    public AddressInfoEntity getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(AddressInfoEntity permanentAddressId) {
        this.permanentAddress = permanentAddressId;
    }

    @Basic
    @Column(name = "TelephoneWork", length = 15)
    public String getTelephoneWork() {
        return telephoneWork;
    }

    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    @Basic
    @Column(name = "TelephoneHome", length = 15)
    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    @Basic
    @Column(name = "Mobile", length = 15)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "Pager", length = 15)
    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    @Basic
    @Column(name = "Fax", length = 15)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "Email", length = 15)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDetailsEntity that = (ContactDetailsEntity) o;
        return idContactDetails == that.idContactDetails &&
                Objects.equals(presentAddress, that.presentAddress) &&
                Objects.equals(permanentAddress, that.permanentAddress) &&
                Objects.equals(telephoneWork, that.telephoneWork) &&
                Objects.equals(telephoneHome, that.telephoneHome) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(pager, that.pager) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(email, that.email);
    }

    @Override
    public String toString() {
        return "ContactDetailsEntity{" +
                "idContactDetails=" + idContactDetails +
                ", presentAddress=" + presentAddress +
                ", permanentAddress=" + permanentAddress +
                ", telephoneWork='" + telephoneWork + '\'' +
                ", telephoneHome='" + telephoneHome + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pager='" + pager + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContactDetails, presentAddress, permanentAddress, telephoneWork, telephoneHome, mobile, pager, fax, email);
    }
}
