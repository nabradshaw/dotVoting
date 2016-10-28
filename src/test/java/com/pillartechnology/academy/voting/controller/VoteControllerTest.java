package com.pillartechnology.academy.voting.controller;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.apache.tomcat.jni.Poll;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class VoteControllerTest {

    @InjectMocks
    private VoteController uut;

    @Mock
    private PollService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ensureAddVotesToPollFindsEachPollItemAndCallsAlterVoteCount() {
        PollModel inputModel = new PollModel();
        inputModel.setId("1");
        inputModel.setTitle("Test Poll");
        PollItemModel inputItem1 = createPollItem("10", 3);
        PollItemModel inputItem2 = createPollItem("11", 1);

        List<PollItemModel> pollItems = new ArrayList<>();
        pollItems.add(inputItem1);
        pollItems.add(inputItem2);

        inputModel.setPollItems(pollItems);

        PollItemModel pollItem1 = createPollItem("10", 0);
        PollItemModel pollItem2 = createPollItem("11", 0);

        when(service.getPollItemById("10")).thenReturn(pollItem1);
        when(service.getPollItemById("11")).thenReturn(pollItem2);

        uut.addVotesToPoll(inputModel);

        assertThat(pollItem1.getVoteCount()).isEqualTo(3);
        assertThat(pollItem2.getVoteCount()).isEqualTo(1);
    }

    private PollItemModel createPollItem(String id, int voteCount) {
        PollItemModel model = new PollItemModel();
        model.setId(id);
        model.setDescription("Default Description!");
        model.alterVoteCount(voteCount);

        return model;
    }
}
