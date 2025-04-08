package com.Institutes.Institute.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Data
public class Institutes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String courses;
    private String price;
    private Long mentors;

    @Lob
    private byte[] photo;

    public Institutes(int id, String name, String courses, String price, Long mentors, byte[] photo) {
        this.id = id;
        this.name = name;
        this.courses = courses;
        this.price = price;
        this.mentors = mentors;
        this.photo = photo;
    }

    public Institutes() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Institutes that = (Institutes) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(courses, that.courses) && Objects.equals(price, that.price) && Objects.equals(mentors, that.mentors) && Objects.deepEquals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, courses, price, mentors, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "Institutes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses='" + courses + '\'' +
                ", price='" + price + '\'' +
                ", mentors=" + mentors +
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

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getMentors() {
        return mentors;
    }

    public void setMentors(Long mentors) {
        this.mentors = mentors;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
