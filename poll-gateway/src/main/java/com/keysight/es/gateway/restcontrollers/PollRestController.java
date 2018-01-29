package com.keysight.es.gateway.restcontrollers;

import com.keysight.es.gateway.entities.PollEntity;
import com.keysight.es.gateway.services.PollService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poll")
public class PollRestController {
    public PollRestController(PollService pollService) {
        this.pollService = pollService;
    }

    private final PollService pollService;

    @PostMapping("/submit")
    public boolean submitPoll(@RequestBody PollEntity[] polls) {
        return this.pollService.submitPoll(polls);
    }


}
