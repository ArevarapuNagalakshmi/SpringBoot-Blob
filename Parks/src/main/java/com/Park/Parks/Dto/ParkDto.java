package com.Park.Parks.Dto;

import jakarta.persistence.Lob;

import java.util.Arrays;
import java.util.Objects;

public class ParkDto {
    private int id;
    private String names;
    private String area;
    private String price;

    @Lob
    private byte[] photo;

    public ParkDto(int id, String names, String area, String price, byte[] photo) {
        this.id = id;
        this.names = names;
        this.area = area;
        this.price = price;
        this.photo = photo;
    }

    public ParkDto(String names, String area, String price, byte[] photo) {
        this.names = names;
        this.area = area;
        this.price = price;
        this.photo = photo;
    }

    public ParkDto() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParkDto parkDto = (ParkDto) o;
        return id == parkDto.id && Objects.equals(names, parkDto.names) && Objects.equals(area, parkDto.area) && Objects.equals(price, parkDto.price) && Objects.deepEquals(photo, parkDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, names, area, price, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "ParkDto{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", area='" + area + '\'' +
                ", price='" + price + '\'' +
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
