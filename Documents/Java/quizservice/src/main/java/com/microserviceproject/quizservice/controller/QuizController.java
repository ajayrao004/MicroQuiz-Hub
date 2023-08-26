package com.microserviceproject.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceproject.quizservice.model.QuestionWrapper;
import com.microserviceproject.quizservice.model.QuizDto;
import com.microserviceproject.quizservice.model.Response;
import com.microserviceproject.quizservice.service.QuizService;

@RestController
@RequestMapping("/quiz") 
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
	{
		return quizService.createQuiz(quizDto);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizByID(@PathVariable Integer id)
	{
		return quizService.getQuizByID(id);
	}
	@GetMapping("/submit/{id}")
	public ResponseEntity<Integer> getResult(@PathVariable Integer id,@RequestBody List<Response> response)
	{
		return quizService.getResult(id,response);
	}

}
