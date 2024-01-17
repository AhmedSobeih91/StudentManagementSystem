package com.test.studentsmanagementsystem.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Course_DTO_Request {

    @JsonProperty("id")
    private int id;
    @JsonProperty("course_name")
    private String course_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", course_name=" + course_name + "]";
    }

}
