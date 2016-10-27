package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollModel;

public class PollService {

    private PollModel model;
    private static final String DEFAULT_TITLE = "Default Poll";

    public PollService() {
        model = new PollModel();
        model.setTitle(DEFAULT_TITLE);
    }

    public PollService(PollModel model) {
        this.model = model;
    }


    public PollModel get() {
        return model;
    }
}
