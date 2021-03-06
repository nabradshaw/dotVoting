package com.pillartechnology.academy.voting.controller;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    PollService pollService;

    @RequestMapping(method = POST)
    public void addVotesToPoll(@RequestBody PollModel pollModel) {
        for (PollItemModel pollItem : pollModel.getPollItems()) {
            pollService.getPollItemById(pollItem.getId()).alterVoteCount(pollItem.getVoteCount());
        }
    }
}
