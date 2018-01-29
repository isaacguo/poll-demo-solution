package com.keysight.es.gateway.restcontroller;

import com.keysight.es.gateway.restcontrollers.QuestionRestController;
import com.keysight.es.gateway.services.QuestionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class QuestionRestControllerTests {

    @Mock
    QuestionService questionService;

    @InjectMocks
    QuestionRestController questionRestController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(questionRestController)
                .build();
    }
    @Test
    public void givenNoArgumentsWhenGetQuestionsThenServiceIsInvoked() throws Exception {

        this.mockMvc.perform(get("/questions")).andExpect(status().isOk());
        verify(this.questionService, times(1)).getQuestions();
    }
}
