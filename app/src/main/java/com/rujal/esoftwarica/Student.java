package com.rujal.esoftwarica;

public class Student {
    private String name, address, gender;
    private int age;
    private int imgProfileId;
    private int imgRemoveId;


    public Student(String name, String address, String gender, int age) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
//        this.imgProfileId = imgProfileId;
//        this.imgRemoveId = imgRemoveId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImgProfileId() {
        return imgProfileId;
    }

    public void setImgProfileId(int imgProfileId) {
        this.imgProfileId = imgProfileId;
    }

    public int getImgRemoveId() {
        return imgRemoveId;
    }

    public void setImgRemoveId(int imgRemoveId) {
        this.imgRemoveId = imgRemoveId;
    }
}
