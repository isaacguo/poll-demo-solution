package com.keysight.es.gateway.restcontroller;


import com.keysight.es.gateway.entities.PollEntity;
import com.keysight.es.gateway.restcontrollers.PollRestController;
import com.keysight.es.gateway.services.PollService;
import com.keysight.es.gateway.test.JsonHelper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PollRestControllerTests {
    @Mock
    PollService pollService;

    @InjectMocks
    PollRestController pollRestController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(pollRestController)
                .build();
    }

    @Test
    public void givenPollEntityArrayWhenSubmitPollsThenServiceIsInvoked() throws Exception {


        PollEntity[] polls = new PollEntity[1];

        PollEntity pe = new PollEntity();
        polls[0] = pe;

        this.mockMvc.perform(post("/poll/submit")
                .content(JsonHelper.asJsonString(polls))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        verify(this.pollService, times(1)).submitPoll(Matchers.<PollEntity[]>any());
    }



}
