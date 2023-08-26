package com.microserviceproject.questionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microserviceproject.questionservice.model.QuestionWrapper;
import com.microserviceproject.questionservice.model.Questions;
import com.microserviceproject.questionservice.model.QuizDto;
import com.microserviceproject.questionservice.model.Response;
import com.microserviceproject.questionservice.dao.QuestionDao;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	public ResponseEntity<List<Questions>> getAllQuestion()
	{
		try
		{
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
		try
		{
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Questions>> addQuestions(List<Questions> questions) {
		try
		{
			return new ResponseEntity<>(questionDao.saveAll(questions),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<String> updateQuestions(Questions questions) {
		 questionDao.save(questions);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	public ResponseEntity<String> deleteQuestion(Integer id) {
	     questionDao.deleteById(id);
	     return new ResponseEntity<>("Row was deleted",HttpStatus.OK);
	}
	public ResponseEntity<List<Integer>> generateQuiz(QuizDto quizDto) {
		List<Integer> questionid=questionDao.findQuizquestionByID(quizDto.getCategory(),quizDto.getNum_of_questions());
		return new ResponseEntity<>(questionid,HttpStatus.OK);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestionByID(List<Integer> questionid) {
	   List<QuestionWrapper> questionWrapper=new ArrayList<>();
	   List<Questions> questions=new ArrayList<>();
	   for(Integer id: questionid)
	   {
		   questions.add(questionDao.findById(id).get());
	   }
	   for(Questions q:questions)
	   {
		  QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionCol(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
		  questionWrapper.add(qw);
	   }
		return new ResponseEntity<>(questionWrapper,HttpStatus.OK);
	}
	public ResponseEntity<Integer> getQuizResult(List<Response> response) {
		int result =0;
		for(Response r: response)
		{
	      Questions questions=questionDao.findById(r.getId()).get();
	      if(questions.getRightAnswer().equals(r.getResponse()))
	    	  result++;
		}
		
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	 

}
