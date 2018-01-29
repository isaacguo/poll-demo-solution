package com.keysight.es.gateway.entities;

public class PollEntity {
    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public AnswerItemEntity getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerItemEntity answer) {
        this.answer = answer;
    }

    QuestionEntity question;
    private AnswerItemEntity answer;

}
