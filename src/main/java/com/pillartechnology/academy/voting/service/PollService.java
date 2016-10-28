package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollService {

    private PollModel poll;
    private static final String DEFAULT_ID = "1";
    private static final String DEFAULT_TITLE = "Default Poll";

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


    public PollModel getPoll() {
        return poll;
    }

    public void savePoll(PollModel poll) {
        this.poll = poll;
    }

    public PollItemModel getPollItemById(String id){
        for(PollItemModel itemModel : poll.getPollItems()){
            if(itemModel.getId().equalsIgnoreCase(id))
                return itemModel;
        }
        return null;
    }
}
