package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PollService {

    private Map<String, PollModel> polls = new HashMap<>();
    private int nextPollId = 0;
    private int nextItemId = 0;

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
        String id = String.valueOf(nextPollId);
        nextPollId++;
        poll.setId(id);
        this.polls.put(id, poll);

        List<PollItemModel> items = poll.getPollItems();
        if(items != null) {
            for(int i = 0; i < items.size(); i++) {
                items.get(i).setId(String.valueOf(nextItemId));
                nextItemId++;
            }
        }

        return poll;
    }

    public PollItemModel getPollItemById(String id){

        try {
            return polls.values().stream()
                .map(p -> p.getPollItems())
                .flatMap(i -> i.stream())
                .filter(i -> id.equals(i.getId()))
                .findFirst()
                .get();
        } catch(NoSuchElementException e) {
            return null;
        }
    }

}
