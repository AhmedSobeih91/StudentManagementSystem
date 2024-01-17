package com.test.studentsmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    import com.test.studentsmanagementsystem.DTO.Quiz_DTO_Request;
import com.test.studentsmanagementsystem.Services.InterfaceQuizService;
import com.test.studentsmanagementsystem.entity.Quiz;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/quiz", consumes = {"application/json"})
public class QuizController {
    
	@Autowired
	private InterfaceQuizService quizService;
        
	@GetMapping("/selectAll")
	public List<Quiz> SelectAllQuiz() {
		List<Quiz>list_of_quiz=quizService.findAll();
		return list_of_quiz;
	}
	
	@GetMapping ("/select/{id}")
	public Quiz SelectQuiz(@PathVariable("id")int id ){
		Quiz quiz=quizService.Find(id);
		if(quiz!=null) {
			return quiz;
		}else
		return null;
		
	}
	@PostMapping ("/insert")
	public String insertQuiz(@RequestBody Quiz_DTO_Request quiz ){
		if(quiz!=null) {
			quizService.insert(quiz);
		}else {return "this data equal null";}
		return "done";
		
	}
	@PutMapping("/update")
	public String updateQuiz(@RequestBody Quiz_DTO_Request quiz ) {
		if(quiz!=null) {
			quizService.update(quiz);
		}else {return "this data equal null";}
		return "done";

}

	@DeleteMapping("/delete/{id}")
	public String deleteQuiz(@PathVariable("id")int id) {
		quizService.delete(id);
		return "done";
	}

}
