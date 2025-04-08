package com.Rapido.Rapido.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Data
public class Rapidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String cost;

    @Lob
    private byte[] photo;

    public Rapidos(int id, String name, String address, String cost, byte[] photo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cost = cost;
        this.photo = photo;
    }

    public Rapidos() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rapidos rapidos = (Rapidos) o;
        return id == rapidos.id && Objects.equals(name, rapidos.name) && Objects.equals(address, rapidos.address) && Objects.equals(cost, rapidos.cost) && Objects.deepEquals(photo, rapidos.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, cost, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "Rapidos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cost='" + cost + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
