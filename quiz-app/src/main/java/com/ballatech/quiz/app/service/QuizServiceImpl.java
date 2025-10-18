package com.ballatech.quiz.app.service;


import com.ballatech.quiz.app.dao.QuestionDao;
import com.ballatech.quiz.app.dao.QuizDao;
import com.ballatech.quiz.app.entity.QuestionWrapper;
import com.ballatech.quiz.app.entity.UserAnswers;
import com.ballatech.quiz.app.entity.questions;
import com.ballatech.quiz.app.entity.quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public String getQuiz(String category, int numQues, String title) {

      List<questions> questions=questionDao.findQuesByCategLimit(category,numQues);

        quiz quizz=new quiz();
        quizz.setTitle(title);
        quizz.setQuestions(questions);

        quizDao.save(quizz);


        return "quiz created succesfully";
    }

    @Override
    public  List<QuestionWrapper> getQuizById(Integer id) {
        Optional<quiz> quizz=quizDao.findById(id);
        List<questions> questionsFromDb=quizz.get().getQuestions();
        List<QuestionWrapper> questionWrapperList=new ArrayList<QuestionWrapper>();
        for(questions q : questionsFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getCategory(),q.getDifficultylevel(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionWrapperList.add(qw);
        }
        return questionWrapperList;
    }

    @Override
    public int submitQuizCalc(Integer id, List<UserAnswers> userAnswersList) {
        Optional<quiz> quizz= quizDao.findById(id);
        List<questions> questionsInParticualarQuiz=quizz.get().getQuestions();
        int i=0;
        int correctAnswerMarks=0;
       for(UserAnswers ua : userAnswersList){
           if(ua.getUseranswers().equals(questionsInParticualarQuiz.get(i).getAnswer())) {
               correctAnswerMarks++;
           }
           i++;
       }

        return correctAnswerMarks;
    }
}
