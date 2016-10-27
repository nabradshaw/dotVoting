package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;

import java.util.ArrayList;
import java.util.List;

public class PollService {

    private PollModel model;
    private static final String DEFAULT_TITLE = "Default Poll";

    public PollService() {
        model = new PollModel();
        model.setTitle(DEFAULT_TITLE);
        List<PollItemModel> items = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            PollItemModel item = new PollItemModel();
            item.setDescription(String.valueOf(i));
            items.add(item);
        }
        model.setPollItems(items);
    }

    public PollService(PollModel model) {
        this.model = model;
    }


    public PollModel get() {
        return model;
    }
}
