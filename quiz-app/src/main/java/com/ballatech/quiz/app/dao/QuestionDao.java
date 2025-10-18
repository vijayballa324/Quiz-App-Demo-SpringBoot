package com.ballatech.quiz.app.dao;

import com.ballatech.quiz.app.entity.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<questions, Integer> {
    List<questions> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQues", nativeQuery = true)
    List<questions> findQuesByCategLimit(String category, int numQues);
}
