package com.Amazon.Amazon.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Data
public class AmazonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String names;
    private String roles;
    private String positions;
    private String packages;

    @Lob
    private byte[] photo;

    public AmazonEntity(int id, String names, String roles, String positions, String packages, byte[] photo) {
        this.id = id;
        this.names = names;
        this.roles = roles;
        this.positions = positions;
        this.packages = packages;
        this.photo = photo;
    }

    public AmazonEntity() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AmazonEntity that = (AmazonEntity) o;
        return id == that.id && Objects.equals(names, that.names) && Objects.equals(roles, that.roles) && Objects.equals(positions, that.positions) && Objects.equals(packages, that.packages) && Objects.deepEquals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, names, roles, positions, packages, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "AmazonEntity{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", roles='" + roles + '\'' +
                ", positions='" + positions + '\'' +
                ", packages='" + packages + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
