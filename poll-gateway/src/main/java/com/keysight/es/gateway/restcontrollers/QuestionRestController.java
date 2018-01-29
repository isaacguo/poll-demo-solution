package com.keysight.es.gateway.restcontrollers;

import com.keysight.es.gateway.entities.QuestionEntity;
import com.keysight.es.gateway.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionRestController {
    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    private final QuestionService questionService;

    @GetMapping()
    public List<QuestionEntity> getQuestions()
    {
        return questionService.getQuestions();
    }


}
