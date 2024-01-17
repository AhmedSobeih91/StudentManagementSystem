package com.test.studentsmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.studentsmanagementsystem.DTO.Student_DTO_Request;
import com.test.studentsmanagementsystem.Services.InterfaceStudentService;
import com.test.studentsmanagementsystem.entity.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/student", consumes = {"application/json"})
public class StudentController {
    
	@Autowired
	private InterfaceStudentService studentservice;
        
	@GetMapping("/selectAll")
	public List<Student> SelectAllStudent() {
		List<Student>list_of_student=studentservice.findAll();
		return list_of_student;
	}
	
	@GetMapping ("/select/{id}")
	public Student SelectStudent(@PathVariable("id")int id ){
	Student student=studentservice.Find(id);
		if(student!=null) {
			return student;
		}else
		return null;
		
	}
	@PostMapping ("/insert")
	public String insertStudent(@RequestBody Student_DTO_Request student ){
		if(student!=null) {
		studentservice.insert(student);
		}else {return "this data equal null";}
		return "done";
		
	}
	@PutMapping("/update")
	public String updatestudent(@RequestBody Student_DTO_Request student ) {
		if(student!=null) {
		 studentservice.update(student);
		}else {return "this data equal null";}
		return "done";

}

	@DeleteMapping("/delete/{id}")
	public String deletestudent(@PathVariable("id")int id) {
		studentservice.delete(id);
		return "done";
	}
	
}
