package com.example.smd_assignments.Assignment_6;

public class Students {
    String name;
    String dept;
    String regno;
    String cgpa;
    String email;

    public Students() {
    }

    public Students(String name, String dept, String regno, String cgpa, String email) {
        this.name = name;
        this.dept = dept;
        this.regno = regno;
        this.cgpa = cgpa;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
