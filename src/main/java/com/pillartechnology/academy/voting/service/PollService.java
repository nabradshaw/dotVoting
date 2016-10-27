package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollModel;

public class PollService {

    private PollModel model;

    public PollService() {
    }

    public PollService(PollModel model) {
        this.model = model;
    }


    public PollModel get() {
        return model;
    }
}
