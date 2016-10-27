package com.pillartechnology.academy.voting.controller;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/list")
public class ListController {

    @RequestMapping(method = GET)
    public PollModel getVotingList() {
        PollModel result = new PollModel();
        result.setId("newId1");
        result.setTitle("New Test Poll");

        PollItemModel pollItem1 = new PollItemModel();
        pollItem1.setId("Item1");
        pollItem1.setDescription("The first item to vote on");

        PollItemModel pollItem2 = new PollItemModel();
        pollItem2.setId("Item2");
        pollItem2.setDescription("The second item to vote on");

        List<PollItemModel> pollItems = new ArrayList<PollItemModel>();
        pollItems.add(pollItem1);
        pollItems.add(pollItem2);

        result.setPollItems(pollItems);

        return result;
    }
}
