package com.keysight.es.gateway.services;

import com.keysight.es.gateway.entities.PollEntity;

public interface PollService {

    boolean submitPoll(PollEntity[] polls);

}
