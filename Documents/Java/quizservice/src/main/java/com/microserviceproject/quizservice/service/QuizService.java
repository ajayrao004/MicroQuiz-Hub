package com.microserviceproject.quizservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microserviceproject.quizservice.dao.QuizDao;
import com.microserviceproject.quizservice.feign.QuizInterface;
import com.microserviceproject.quizservice.model.QuestionWrapper;

import com.microserviceproject.quizservice.model.Quiz;
import com.microserviceproject.quizservice.model.QuizDto;
import com.microserviceproject.quizservice.model.Response;

@Service
public class QuizService {
	 @Autowired
      QuizDao quizDao;
	 @Autowired
	  QuizInterface quizInterface;
	 
	public ResponseEntity<String> createQuiz(QuizDto quizDto) 
	{
		
		//here we need for call the generate url in questionservice 
		List<Integer> questionid=quizInterface.generateQuiz(quizDto).getBody();
		Quiz quiz=new Quiz();
		quiz.setQuestionIds(questionid);
		quizDao.save(quiz);
		return new ResponseEntity<>("Quiz Created",HttpStatus.CREATED);
		
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizByID(Integer id) 
	{
		  Quiz quiz= quizDao.findById(id).get();
		  List<Integer> questionIds=quiz.getQuestionIds();
		  ResponseEntity<List<QuestionWrapper>> questionWrapper= quizInterface.getQuizQuestionByID(questionIds);
		return questionWrapper;
	}
	public ResponseEntity<Integer> getResult(Integer id, List<Response> response) {
		ResponseEntity<Integer> result=quizInterface.getQuizResult(response);
		return result;
	}

	
    
}
