package com.microserviceproject.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceproject.questionservice.model.QuestionWrapper;
import com.microserviceproject.questionservice.model.Questions;
import com.microserviceproject.questionservice.model.QuizDto;
import com.microserviceproject.questionservice.model.Response;
import com.microserviceproject.questionservice.service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestions()
	{
		return questionService.getAllQuestion();
	}
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category)
	{
		return questionService.getQuestionsByCategory(category);
	}
    @PostMapping("/add")
    public ResponseEntity<List<Questions>> addQuestions(@RequestBody List<Questions> questions)
    {
    	return questionService.addQuestions(questions);
    }
    
    @PutMapping("/update")
    public ResponseEntity<String> updateQuestions(@RequestBody Questions questions)
    {
    	return questionService.updateQuestions(questions);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteQuestion(@PathVariable Integer id)
    {
    	 return questionService.deleteQuestion(id);
 
    }
  //generate
    @PostMapping("/generate")
    public ResponseEntity<List<Integer>> generateQuiz(@RequestBody QuizDto quizDto)
    {
    	 return questionService.generateQuiz(quizDto);
 
    }
    @GetMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionByID(@RequestBody List<Integer> questionid)
    {
    	return questionService.getQuizQuestionByID(questionid);
    }
  	@GetMapping("/result")
  	 public ResponseEntity<Integer> getQuizResult(@RequestBody List<Response> response)
  	 {
  		return questionService.getQuizResult(response);
  	 }
}
