package com.test.studentsmanagementsystem.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quiz_DTO_Request {

    @JsonProperty("id")
    private int id;
    @JsonProperty("course_name")
    private String course_name;
    @JsonProperty("quiz_name")
    private String quiz_name;
    @JsonProperty("quiz_datetime")
    private String quiz_datetime;
    @JsonProperty("quiz_duration")
    private int quiz_duration;
    @JsonProperty("quiz_score")
    private double quiz_score;

    public Quiz_DTO_Request() {

    }

    public Quiz_DTO_Request(String course_name, String quiz_name, String quiz_datetime, int quiz_duration, double quiz_score) {

        this.course_name = course_name;
        this.quiz_name = quiz_name;
        this.quiz_datetime = quiz_datetime;
        this.quiz_duration = quiz_duration;
        this.quiz_score = quiz_score;
    }

    public Quiz_DTO_Request(int id, String course_name, String quiz_name, String quiz_datetime, int quiz_duration, double quiz_score) {
        this.id = id;
        this.course_name = course_name;
        this.quiz_name = quiz_name;
        this.quiz_datetime = quiz_datetime;
        this.quiz_duration = quiz_duration;
        this.quiz_score = quiz_score;
    }

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

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public String getQuiz_datetime() {
        return quiz_datetime;
    }

    public void setQuiz_time(String quiz_datetime) {
        this.quiz_datetime = quiz_datetime;
    }

    public int getQuiz_duration() {
        return quiz_duration;
    }

    public void setQuiz_duration(int quiz_duration) {
        this.quiz_duration = quiz_duration;
    }

    public double getQuiz_score() {
        return quiz_score;
    }

    public void setQuiz_score(double quiz_score) {
        this.quiz_score = quiz_score;
    }

    @Override
    public String toString() {
        return "Quiz [id=" + id + ", course_name=" + course_name + ", quiz_name=" + quiz_name + ", quiz_time="
                + quiz_datetime + ", quiz_duration=" + quiz_duration + ", quiz_score=" + quiz_score + "]";
    }

}
