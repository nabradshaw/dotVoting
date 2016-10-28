package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PollService {

    private Map<String, PollModel> polls = new HashMap<>();
    private int numPolls = 0;

    public PollService() {

    }


    public PollService(Collection<PollModel> polls) {
        for(PollModel poll : polls) {
            this.polls.put(poll.getId(), poll);
        }
    }

    public PollModel getPoll(String id) {
        return polls.get(id);
    }

    public PollModel createPoll(PollModel poll) {
        String id = String.valueOf(numPolls);
        numPolls++;
        poll.setId(id);
        this.polls.put(id, poll);

        List<PollItemModel> items = poll.getPollItems();
        if(items != null) {
            for(int i = 0; i < items.size(); i++) {
                items.get(i).setId(String.valueOf(i));
            }
        }

        return poll;
    }
}
