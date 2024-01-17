package com.test.studentsmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.studentsmanagementsystem.DTO.Course_DTO_Request;
import com.test.studentsmanagementsystem.Services.InterfaceCourseService;
import com.test.studentsmanagementsystem.entity.Course;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/course", consumes = {"application/json"})
public class CourseController {
    
	@Autowired
	private InterfaceCourseService courseService;
        
	@GetMapping("/selectAll")
	public List<Course> SelectAllCourse() {
		List<Course>list_of_course=courseService.findAll();
		return list_of_course;
	}
	
	@GetMapping ("/select/{id}")
	public Course SelectCourse(@PathVariable("id") int id ){
		Course course=courseService.Find(id);
		if(course!=null) {
			return course;
		}else
		return null;
		
	}
	@PostMapping ("/insert")
	public String insertCourse(@RequestBody Course_DTO_Request course ){
		if(course!=null) {
			courseService.insert(course);
		}else {return "this data equal null";}
		return "done";
		
	}
	@PutMapping("/update")
	public String updateCourse(@RequestBody Course_DTO_Request course ) {
		if(course!=null) {
			courseService.update(course);
		}else {return "this data equal null";}
		return "done";

}

	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@PathVariable("id")int id) {
		courseService.delete(id);
		return "done";
	}

	
}
