package com.test.studentsmanagementsystem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Quiz")
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Quiz_Name")
    private String quiz_name;
    @Column(name = "quiz_Time")
    private String quiz_datetime;
    @Column(name = "Quiz_Duration")
    private int quiz_duration;
    @Column(name = "Quiz_Score")
    private double quiz_score;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    @JoinTable(name = "students_quizes",
            joinColumns = @JoinColumn(name = "quizId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    private List<Student> studentQuizes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudent() {
        return studentQuizes;
    }

    public void setStudent(List<Student> studentQuizes) {
        this.studentQuizes = studentQuizes;
    }

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", quiz_name=" + quiz_name + ", quiz_datetime=" + quiz_datetime + ", quiz_duration=" + quiz_duration + ", quiz_score=" + quiz_score + ", course=" + course + '}';
    }

}
