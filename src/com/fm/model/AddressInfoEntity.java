package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AddressInfo", schema = "dbo", catalog = "Java1_Hospital")
public class AddressInfoEntity {
    private int idAddressInfo;
    private Integer doorNo;
    private String street;
    private String area;
    private String city;
    private String state;
    private String pincode;

    public AddressInfoEntity() {
    }

    public AddressInfoEntity(int doorNo, String street, String area, String city, String state, String pincode) {
        this.doorNo = doorNo;
        this.street = street;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }



    @Id
    @GeneratedValue
    @Column(name = "IDAddressInfo", nullable = false)
    public int getIdAddressInfo() {
        return idAddressInfo;
    }

    public void setIdAddressInfo(int idAddressInfo) {
        this.idAddressInfo = idAddressInfo;
    }

    @Basic
    @Column(name = "DoorNo")
    public Integer getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(Integer doorNo) {
        this.doorNo = doorNo;
    }

    @Basic
    @Column(name = "Street", length = 20)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "Area", length = 10)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "City", length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "State", length = 20)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Pincode", length = 10)
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressInfoEntity that = (AddressInfoEntity) o;
        return idAddressInfo == that.idAddressInfo &&
                Objects.equals(doorNo, that.doorNo) &&
                Objects.equals(street, that.street) &&
                Objects.equals(area, that.area) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(pincode, that.pincode);
    }

    @Override
    public String toString() {
        return "AddressInfoEntity{" +
                "idAddressInfo=" + idAddressInfo +
                ", doorNo=" + doorNo +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddressInfo, doorNo, street, area, city, state, pincode);
    }
}
