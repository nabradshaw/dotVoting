package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PollService {

    private PollModel poll;
    private Map<String, PollModel> polls = new HashMap<>();
    private static final String DEFAULT_ID = "1";
    private static final String DEFAULT_TITLE = "Default Poll";
    private int numPolls = 0;

    public PollService() {
        poll = new PollModel();
        poll.setId(DEFAULT_ID);
        poll.setTitle(DEFAULT_TITLE);
        List<PollItemModel> items = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            PollItemModel item = new PollItemModel();
            item.setDescription(String.valueOf(i));
            item.setId(String.valueOf(i));
            items.add(item);
        }
        poll.setPollItems(items);
    }

    public PollService(PollModel poll) {
        this.poll = poll;
    }

    public PollService(Collection<PollModel> polls) {
        for(PollModel poll : polls) {
            this.polls.put(poll.getId(), poll);
        }
    }


    public PollModel getPoll() {
        return poll;
    }

    public void savePoll(PollModel poll) {
        this.poll = poll;
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
