package com.ballatech.quiz.app.dao;

import com.ballatech.quiz.app.entity.quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<quiz, Integer> {


}
