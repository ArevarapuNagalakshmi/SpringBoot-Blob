package com.games.game.dto;

import jakarta.persistence.Lob;

import java.util.Arrays;
import java.util.Objects;

public class GameDto {

    private int rno;
    private String names;
    private String rules;
    private Long numbers;
    private String type;

    @Lob
    private byte[] image;

    public GameDto(int rno, String names, String rules, Long numbers, String type, byte[] image) {
        this.rno = rno;
        this.names = names;
        this.rules = rules;
        this.numbers = numbers;
        this.type = type;
        this.image = image;
    }

    public GameDto() {
        super();
    }

    public GameDto(String names, String rules, Long numbers, String type, byte[] image) {
        this.names = names;
        this.rules = rules;
        this.numbers = numbers;
        this.type = type;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameDto gameDto = (GameDto) o;
        return rno == gameDto.rno && Objects.equals(names, gameDto.names) && Objects.equals(rules, gameDto.rules) && Objects.equals(numbers, gameDto.numbers) && Objects.equals(type, gameDto.type) && Objects.deepEquals(image, gameDto.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rno, names, rules, numbers, type, Arrays.hashCode(image));
    }

    @Override
    public String toString() {
        return "GameDto{" +
                "rno=" + rno +
                ", names='" + names + '\'' +
                ", rules='" + rules + '\'' +
                ", numbers=" + numbers +
                ", type='" + type + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
