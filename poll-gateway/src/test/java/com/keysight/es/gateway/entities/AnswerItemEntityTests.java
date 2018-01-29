package com.keysight.es.gateway.entities;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AnswerItemEntityTests {

    QuestionEntity qe = new QuestionEntity();

    @Test
    public void givenAnswerItemEntityThenItHasFieldId() {
        AnswerItemEntity answerItemEntity = getAnswerItemEntity();
        assertThat(answerItemEntity, hasProperty("id", is(1L)));
    }

    @Test
    public void givenAnswerItemEntityThenItHasFieldQuestion() {
        AnswerItemEntity answerItemEntity = getAnswerItemEntity();
        assertThat(answerItemEntity, hasProperty("question", is(qe)));
    }

    @Test
    public void givenAnswerItemEntityThenItHasFieldAnswer() {
        AnswerItemEntity answerItemEntity = getAnswerItemEntity();
        assertThat(answerItemEntity, hasProperty("answer", is("A1")));
    }
    @Test
    public void givenAnswerItemEntityThenItHasFieldSelectedCount() {
        AnswerItemEntity answerItemEntity = getAnswerItemEntity();
        assertThat(answerItemEntity, hasProperty("selectedCount", is(2)));
    }

    private AnswerItemEntity getAnswerItemEntity() {

        qe.setId(1L);
        qe.setQuestion("Q1");
        qe.addAvailableAnswer("A1");
        qe.addAvailableAnswer("A2");
        AnswerItemEntity answerItemEntity = new AnswerItemEntity();
        answerItemEntity.setId(1L);
        answerItemEntity.setQuestion(qe);
        answerItemEntity.setAnswer("A1");
        answerItemEntity.setSelectedCount(2);


        return answerItemEntity;
    }
}
