package com.Rapido.Rapido.Dto;

import jakarta.persistence.Lob;

import java.util.Arrays;
import java.util.Objects;

public class RapidoDto {
    private int id;
    private String name;
    private String address;
    private String cost;

    @Lob
    private byte[] photo;

    public RapidoDto(int id, String name, String address, String cost, byte[] photo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cost = cost;
        this.photo = photo;
    }

    public RapidoDto() {
        super();
    }

    public RapidoDto(String name, String address, String cost, byte[] photo) {
        this.name = name;
        this.address = address;
        this.cost = cost;
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RapidoDto rapidoDto = (RapidoDto) o;
        return id == rapidoDto.id && Objects.equals(name, rapidoDto.name) && Objects.equals(address, rapidoDto.address) && Objects.equals(cost, rapidoDto.cost) && Objects.deepEquals(photo, rapidoDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, cost, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "RapidoDto{" +
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
