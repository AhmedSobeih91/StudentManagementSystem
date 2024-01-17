package com.test.studentsmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.studentsmanagementsystem.DTO.Teacher_DTO_Request;
import com.test.studentsmanagementsystem.Services.InterfaceTeacherService;
import com.test.studentsmanagementsystem.entity.Teacher;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/teachr", consumes = {"application/json"})
public class TeacherController {
    
	@Autowired
	private InterfaceTeacherService teacherService;
        
	@GetMapping("/selectAll")
	public List<Teacher> SelectAllTeacher() {
		List<Teacher>list_of_teacher=teacherService.findAll();
		return list_of_teacher;
	}
	
	@GetMapping ("/select/{id}")
	public Teacher Selectteacher(@PathVariable("id")int id ){
		Teacher teacher=teacherService.Find(id);
		if(teacher!=null) {
			return teacher;
		}else
		return null;
		
	}
	@PostMapping ("/insert")
	public String insertTeacher(@RequestBody Teacher_DTO_Request teacher ){
		if(teacher!=null) {
			teacherService.insert(teacher);
		}else {return "this data equal null";}
		return "done";
		
	}
	@PutMapping("/update")
	public String updateTeacher(@RequestBody Teacher_DTO_Request teacher ) {
		if(teacher!=null) {
			teacherService.update(teacher);
		}else {return "this data equal null";}
		return "done";

}

	@DeleteMapping("/delete/{id}")
	public String deleteTeacher(@PathVariable("id")int id) {
		teacherService.delete(id);
		return "done";
	}
	
}
