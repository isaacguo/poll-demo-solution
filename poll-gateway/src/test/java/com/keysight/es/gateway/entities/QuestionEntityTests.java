package com.keysight.es.gateway.entities;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class QuestionEntityTests {
    @Test
    public void givenQuestionEntityThenItHasFieldQuestion() {
        QuestionEntity questionEntity = getQuestionEntity();
        assertThat(questionEntity, hasProperty("question", is("Q1")));
    }

    @Test
    public void givenQuestionEntityThenItHasFieldId() {
        QuestionEntity questionEntity = getQuestionEntity();
        assertThat(questionEntity, hasProperty("id", is(1L)));
    }
    @Test
    public void givenQuestionEntityThenItHasFieldAvailableAnswer()
    {
        QuestionEntity questionEntity=getQuestionEntity();
        assertThat(questionEntity,hasProperty("availableAnswers"));
    }

    private QuestionEntity getQuestionEntity() {
        QuestionEntity qe = new QuestionEntity();
        qe.setQuestion("Q1");
        qe.setId(1L);
        qe.addAvailableAnswer("1");
        qe.addAvailableAnswer("2");
        qe.addAvailableAnswer("3");

        return qe;
    }
}
