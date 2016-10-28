package com.pillartechnology.academy.voting.controller;

import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ListController {

    @Autowired
    PollService pollService;

    @RequestMapping(method = GET, value = "/api/poll/{id}")
    public PollModel getPoll(@PathVariable("id") String id) {
        return pollService.getPoll(id);
    }

    @RequestMapping(method = POST, value = "/api/poll")
    public PollModel savePoll(@RequestBody PollModel poll) {
        return pollService.createPoll(poll);
    }
}
