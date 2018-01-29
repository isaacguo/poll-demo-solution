package com.keysight.es.gateway.services;


import com.keysight.es.gateway.entities.QuestionEntity;

import java.util.List;

public interface QuestionService {

    List<QuestionEntity> getQuestions();
}
