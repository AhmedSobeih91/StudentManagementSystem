package  com.test.studentsmanagementsystem.entity;

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
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "Course_Name")
	private String course_name;
        
        @ManyToMany
        @JoinTable(name = "students_courses",
                joinColumns = @JoinColumn(name = "courseId"),
                inverseJoinColumns = @JoinColumn(name = "studentId"))
        private List<Student> student;

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

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
        
       

	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + "]";
	}

}
