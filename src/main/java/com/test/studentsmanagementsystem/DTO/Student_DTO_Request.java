package com.test.studentsmanagementsystem.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Student_DTO_Request {

        @JsonProperty("id")
	private int id;
        @JsonProperty("fristname")
	private String fristname;
        @JsonProperty("lastname")
	private String lastname;
        @JsonProperty("address")
	private String address;
        @JsonProperty("phone_number")
	private long phone_number;
        @JsonProperty("email")
	private String email;
        @JsonProperty("quizes")
	private List<Integer> quizes;
        @JsonProperty("Courses")
	private List<Integer> Courses;


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

    public List<Integer> getQuiz() {
        return quizes;
    }

    public void setQuiz(List<Integer> quizes) {
        this.quizes = quizes;
    }

    public List<Integer> getCourse() {
        return Courses;
    }

    public void setCourse(List<Integer> Courses) {
        this.Courses = Courses;
    }

	

	@Override
	public String toString() {
		return "Student_DTO_Request [id=" + id + ", fristname=" + fristname + ", lastname=" + lastname + ", address="
				+ address + ", phone_number=" + phone_number + ", email=" + email + ", quiz=" + quizes + ", Course="
				+ Courses + "]";
	}

}
