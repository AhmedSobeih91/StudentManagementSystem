package com.test.studentsmanagementsystem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "FristName")
    private String fristname;
    @Column(name = "LastName")
    private String lastname;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone_Number")
    private long phone_number;
    @Column(name = "Email")
    private String email;

    @ManyToMany(mappedBy = "studentQuizes")
    private List<Quiz> quez;
    @ManyToMany(mappedBy = "student")
    private List<Course> cours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public List<Quiz> getQuez() {
        return quez;
    }

    public void setQuez(List<Quiz> quez) {
        this.quez = quez;
    }

    public List<Course> getCours() {
        return cours;
    }

    public void setCours(List<Course> cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fristname=" + fristname + ", lastname=" + lastname + ", address=" + address + ", phone_number=" + phone_number + ", email=" + email + ", quez=" + quez + ", cours=" + cours + '}';
    }

}
