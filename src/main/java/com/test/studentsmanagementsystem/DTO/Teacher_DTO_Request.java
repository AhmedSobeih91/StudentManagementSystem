package com.test.studentsmanagementsystem.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Teacher_DTO_Request {

    @JsonProperty("id")
    private int id;
    @JsonProperty("teacherName")
    private String teacherName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone_number")
    private long phone_number;
    @JsonProperty("email")
    private String email;
    @JsonProperty("courseId")
    private List<Integer> courseId;

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

    public List<Integer> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<Integer> courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Teacher_DTO_Request{" + "id=" + id + ", teacherName=" + teacherName + ", address=" + address + ", phone_number=" + phone_number + ", email=" + email + ", courseId=" + courseId + '}';
    }

}
