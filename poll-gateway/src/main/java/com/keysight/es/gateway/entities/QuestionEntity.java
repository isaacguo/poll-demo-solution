package com.keysight.es.gateway.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class QuestionEntity {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerItemEntity> getAvailableAnswers() {
        return availableAnswers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference("question-answers")
    private List<AnswerItemEntity> availableAnswers = new LinkedList<>();


    public void addAvailableAnswer(String answer) {
        AnswerItemEntity aie = new AnswerItemEntity();
        aie.setAnswer(answer);
        aie.setQuestion(this);
        this.availableAnswers.add(aie);
    }
}
