package com.microserviceproject.quizservice.model;

public class QuizDto {
	private String category;
	private Integer num_of_questions;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category= category;
	}
	public Integer getNum_of_questions() {
		return num_of_questions;
	}
	public void setNum_of_questions(Integer num_of_questions) {
		this.num_of_questions = num_of_questions;
	}
	@Override
	public String toString() {
		return "QuizDto [category=" + category + ", num_of_questions=" + num_of_questions + "]";
	}
	public QuizDto(String title, String category, Integer num_of_questions) {
		super();
		this.category = category;
		this.num_of_questions = num_of_questions;
	}
	
}
