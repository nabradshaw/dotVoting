package com.pillartechnology.academy.voting.controller;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/list")
public class ListController {

    @Autowired
    PollService pollService;

    @RequestMapping(method = GET)
    public PollModel getPoll() {
        return pollService.getPoll();
    }

    public PollModel getPoll(String id) {
        return pollService.getPoll(id);
    }
    @RequestMapping(method = POST)
    public void savePoll(@RequestBody PollModel poll) {
        poll.setId("1");
        List<PollItemModel> items = poll.getPollItems();
        if(items != null) {
            for(int i = 0; i < items.size(); i++) {
                items.get(i).setId(String.valueOf(i));
            }
        }

        pollService.savePoll(poll);
    }
}
