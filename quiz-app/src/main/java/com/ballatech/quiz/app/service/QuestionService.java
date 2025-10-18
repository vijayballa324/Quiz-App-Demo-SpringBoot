package com.ballatech.quiz.app.service;

import com.ballatech.quiz.app.entity.questions;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    ResponseEntity<List<questions>> getQuestions();

    List<questions> getQuestionsByCategory(String category);

    String addQuestionsDb(questions ques);
}
