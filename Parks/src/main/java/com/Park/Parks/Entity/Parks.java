package com.Park.Parks.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Data
public class Parks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String names;
    private String area;
    private String price;

    @Lob
    private byte[] photo;

    public Parks(int id, String names, String area, String price, byte[] photo) {
        this.id = id;
        this.names = names;
        this.area = area;
        this.price = price;
        this.photo = photo;
    }

    public Parks() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parks parks = (Parks) o;
        return id == parks.id && Objects.equals(names, parks.names) && Objects.equals(area, parks.area) && Objects.equals(price, parks.price) && Objects.deepEquals(photo, parks.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, names, area, price, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "Parks{" +
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
