package com.ojiraphers.thymelef.controller.moder.dto;

public class Member {

    private String name;
    private int age;
    private char gender;
    private String addresss;

    public Member() {
    }

    public Member(String name, int age, char gender, String addresss) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.addresss = addresss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", addresss='" + addresss + '\'' +
                '}';
    }
}
