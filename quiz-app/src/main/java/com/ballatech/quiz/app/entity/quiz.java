package com.ballatech.quiz.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="quiz")
public class quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "questions")
    @ManyToMany
    private List<questions> questions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<questions> questions) {
        this.questions = questions;
    }
}
