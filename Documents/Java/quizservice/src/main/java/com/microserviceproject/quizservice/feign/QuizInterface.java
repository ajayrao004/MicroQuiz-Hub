package com.microserviceproject.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microserviceproject.quizservice.model.QuestionWrapper;
import com.microserviceproject.quizservice.model.QuizDto;
import com.microserviceproject.quizservice.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	@PostMapping("/questions/generate")
    public ResponseEntity<List<Integer>> generateQuiz(@RequestBody QuizDto quizDto);
    @GetMapping("questions/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionByID(@RequestBody List<Integer> questionid);
  	@GetMapping("questions/result")
  	 public ResponseEntity<Integer> getQuizResult(@RequestBody List<Response> response);
}
