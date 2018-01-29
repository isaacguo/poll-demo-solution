package com.keysight.es.gateway.services;

import com.keysight.es.gateway.entities.AnswerItemEntity;
import com.keysight.es.gateway.entities.PollEntity;
import com.keysight.es.gateway.entities.QuestionEntity;
import com.keysight.es.gateway.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PollServiceImpl implements PollService {
    public PollServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private final QuestionRepository questionRepository;

    @Override
    public boolean submitPoll(PollEntity[] polls) {

        if (polls == null) throw new RuntimeException("Polls should not be null.");
        if (polls.length == 0) throw new RuntimeException("Polls array is empty.");


        Arrays.stream(polls).forEach(r -> {
            QuestionEntity qe = questionRepository.findOne(r.getQuestion().getId());
            if (qe == null) throw new RuntimeException();
            AnswerItemEntity aie = qe.getAvailableAnswers().stream().filter(a -> {
                return a.getId() == r.getAnswer().getId();
            }).findFirst().orElse(null);
            aie.increaseByOne();
            questionRepository.save(qe);

        });

        return true;
    }


}
