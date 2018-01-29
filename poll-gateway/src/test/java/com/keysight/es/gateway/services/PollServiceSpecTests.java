package com.keysight.es.gateway.services;

import com.keysight.es.gateway.entities.PollEntity;
import com.keysight.es.gateway.repositories.QuestionRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class PollServiceSpecTests {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    QuestionRepository questionRepository;
    PollService pollService;

    @Before
    public void before() {

        this.questionRepository = mock(QuestionRepository.class);
        this.pollService = spy(new PollServiceImpl(this.questionRepository));
    }

    @Test
    public void givenNullWhenSubmitPollsThenThrowRuntimeException() {
        this.exception.expect(RuntimeException.class);
        this.exception.expectMessage("Polls should not be null.");
        this.pollService.submitPoll(null);
    }

    @Test
    public void givenEmptyWhenSubmitPollsThenThrowRuntimeException() {
        PollEntity[] polls = new PollEntity[0];
        this.exception.expect(RuntimeException.class);
        this.exception.expectMessage("Polls array is empty.");
        this.pollService.submitPoll(polls);
    }

    @Test
    public void given2PollsWhenSubmitPollsThenQuestionRepositoryIsInvoked2Times() {


    }
}
