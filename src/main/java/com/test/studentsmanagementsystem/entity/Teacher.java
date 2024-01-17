package com.test.studentsmanagementsystem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Teacher_Name")
    private String teacherName;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone_Number")
    private long phone_number;
    @Column(name = "Email")
    private String email;
    
    @OneToMany
    @JoinColumn(name = "course_id")
    private List<Course> course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

 

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", teacherName=" + teacherName + ", address=" + address + ", phone_number=" + phone_number + ", email=" + email + ", course=" + course + '}';
    }

}
