package com.ballatech.quiz.app.controller;

import com.ballatech.quiz.app.entity.QuestionWrapper;
import com.ballatech.quiz.app.entity.UserAnswers;
import com.ballatech.quiz.app.entity.questions;
import com.ballatech.quiz.app.entity.quiz;
import com.ballatech.quiz.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public String getQuiz(@RequestParam String category,@RequestParam int numQues,@RequestParam String title){
        return quizService.getQuiz(category,numQues,title);
    }

    @GetMapping("getQuiz/{id}")
    public  List<QuestionWrapper> getQuizById(@PathVariable Integer id){
        return quizService.getQuizById(id);

    }

    @PostMapping("submitQuiz/{id}")
    public int submitQuiz(@PathVariable Integer id, @RequestBody List<UserAnswers> userAnswersList){
        return quizService.submitQuizCalc(id,userAnswersList);
    }


}
