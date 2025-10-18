package com.ballatech.quiz.app.controller;

import com.ballatech.quiz.app.entity.questions;
import com.ballatech.quiz.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizapp")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/questions")
    public ResponseEntity<List<questions>> getQuestions(){
        return questionService.getQuestions();

    }

    @GetMapping("/questions/{category}")
    public List<questions> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/addquestions")
    public String addQuestionsDb(@RequestBody questions ques){
      return questionService.addQuestionsDb(ques);
    }



}
