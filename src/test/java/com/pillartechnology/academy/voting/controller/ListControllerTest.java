package com.pillartechnology.academy.voting.controller;


import com.pillartechnology.academy.voting.controller.ListController;
import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListControllerTest {
    ListController uut;

    @Test
    public void ensureEndpointReturnsAPollModelWhenCalled() {
        uut = new ListController();

        PollModel expected = new PollModel();
        expected.setId("newId1");
        expected.setTitle("New Test Poll");

        PollItemModel expectedItem1 = new PollItemModel();
        expectedItem1.setId("Item1");
        expectedItem1.setDescription("The first item to vote on");

        PollItemModel expectedItem2 = new PollItemModel();
        expectedItem2.setId("Item2");
        expectedItem2.setDescription("The second item to vote on");

        List<PollItemModel> expectedItems = new ArrayList<PollItemModel>();
        expectedItems.add(expectedItem1);
        expectedItems.add(expectedItem2);

        expected.setPollItems(expectedItems);

        assertEquals(expected, uut.getVotingList());
    }
}
