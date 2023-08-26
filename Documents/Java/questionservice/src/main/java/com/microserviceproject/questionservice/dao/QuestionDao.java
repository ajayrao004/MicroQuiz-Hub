package com.microserviceproject.questionservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microserviceproject.questionservice.model.Questions;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {

	List<Questions> findByCategory(String category);
   @Query(value="SELECT q.id FROM questions q Where q.category= :category ORDER BY RANDOM() LIMIT :num_of_questions", nativeQuery = true)
     List<Integer> findQuizquestionByID(@Param("category") String category,@Param("num_of_questions") Integer num_of_questions);

}
