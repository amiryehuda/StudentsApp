package com.example.studentsappnew.model;

import java.io.Serializable;

public class Student implements Serializable {

    String name="";
    String id = "";
    String address = "";
    String phone = "";
    boolean isChecked = false;


    public Student(String name, String id, String address, String phone, boolean isChecked) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.isChecked = isChecked;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void updateStudent(String name, String id, String address, String phone, boolean isChecked){
        this.setName(name);
        this.setId(id);
        this.setAddress(address);
        this.setPhone(phone);
        this.setChecked(isChecked);
    }



}
