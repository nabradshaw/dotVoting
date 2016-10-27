package com.pillartechnology.academy.voting.controller;

import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/list")
public class ListController {

    @Autowired
    PollService pollService;

    @RequestMapping(method = GET)
    public PollModel getPoll() {
        return pollService.getPoll();
    }

    public void savePoll(PollModel poll) {
        pollService.savePoll(poll);
    }
}
