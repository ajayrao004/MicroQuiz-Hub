package com.microserviceproject.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microserviceproject.quizservice.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{
	

}
