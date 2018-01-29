package com.keysight.es.gateway.services;


import com.keysight.es.gateway.entities.QuestionEntity;
import com.keysight.es.gateway.repositories.QuestionRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class QuestionServiceSpecTests {

    QuestionRepository questionRepository;
    QuestionService questionService;

    @Before
    public void before() {

        this.questionRepository = mock(QuestionRepository.class);
        this.questionService = spy(new QuestionServiceImpl(this.questionRepository));
    }

    @Test
    public void givenWhenGetQuestionsThenReturnQuestions()
    {

        List<QuestionEntity> list=new LinkedList<>();
        QuestionEntity qe=new QuestionEntity();
        qe.setQuestion("Q1");
        list.add(qe);
        doReturn(list).when(this.questionRepository).findAll();

        List<QuestionEntity> result=this.questionService.getQuestions();
        verify(this.questionRepository,times(1)).findAll();
        assertThat(result).hasSize(1);
    }

}
