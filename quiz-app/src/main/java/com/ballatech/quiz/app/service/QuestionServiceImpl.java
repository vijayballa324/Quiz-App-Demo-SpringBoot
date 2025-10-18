package com.ballatech.quiz.app.service;

import com.ballatech.quiz.app.dao.QuestionDao;
import com.ballatech.quiz.app.entity.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@Repository
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;



    @Override
    public ResponseEntity<List<questions>> getQuestions() {
        try {
            List<questions> questionss = questionDao.findAll();
            return new ResponseEntity<>(questionss, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<questions> getQuestionsByCategory(String category) {
        List<questions> cateQuestions=questionDao.findByCategory(category);
        return cateQuestions;
    }

    @Override
    public String addQuestionsDb(questions ques) {
        questionDao.save(ques);
        return "SUCCESSFULLY INSERTED";
    }
}
