package com.ballatech.quiz.app.service;

import com.ballatech.quiz.app.entity.QuestionWrapper;
import com.ballatech.quiz.app.entity.UserAnswers;
import com.ballatech.quiz.app.entity.quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {


    String getQuiz(String category, int numQues, String title) ;

    List<QuestionWrapper> getQuizById(Integer id);

    int submitQuizCalc(Integer id, List<UserAnswers> userAnswersList);
}
