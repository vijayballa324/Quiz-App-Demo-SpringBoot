package com.ballatech.quiz.app.entity;




public class UserAnswers {
    private Integer id;
    private String useranswers;

    public UserAnswers(Integer id, String useranswers) {
        this.id = id;
        this.useranswers = useranswers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseranswers() {
        return useranswers;
    }

    public void setUseranswers(String useranswers) {
        this.useranswers = useranswers;
    }
}
