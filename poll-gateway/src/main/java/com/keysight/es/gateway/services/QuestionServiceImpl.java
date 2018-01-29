package com.keysight.es.gateway.services;

import com.keysight.es.gateway.entities.QuestionEntity;
import com.keysight.es.gateway.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private final QuestionRepository questionRepository;

    @Override
    public List<QuestionEntity> getQuestions() {
        return this.questionRepository.findAll();
    }
}
