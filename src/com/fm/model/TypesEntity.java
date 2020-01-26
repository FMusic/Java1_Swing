package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Types", schema = "dbo", catalog = "Java1_Hospital")
public class TypesEntity {
    private int idType;
    private String typeName;

    public TypesEntity() {
    }

    public TypesEntity(String typeName) {
        this.typeName = typeName;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDType")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "TypeName", length = 20)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypesEntity that = (TypesEntity) o;
        return idType == that.idType &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, typeName);
    }

    @Override
    public String toString() {
        return "TypesEntity{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
