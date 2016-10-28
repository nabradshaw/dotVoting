package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PollServiceTest {

    @Test
    public void getPoll_RetrievesThePoll() {
        PollModel expected = new PollModel();
        PollService pollService = new PollService(expected);
        PollModel actual = pollService.getPoll();
        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void savePoll_OverwritesTheCurrentPollWithNewPoll() {
        PollModel expected = new PollModel();
        PollService pollService = new PollService();

        pollService.savePoll(expected);
        assertThat(pollService.getPoll()).isSameAs(expected);
    }

    @Test
    public void whenNoPollProvided_CreatesADefaultPoll_PollHasAnId() {
        PollService pollService = new PollService();
        PollModel poll = pollService.getPoll();

        assertThat(poll.getId()).isEqualTo("1");
    }

    @Test
    public void whenNoPollProvided_CreatesADefaultPoll_WithATitle() {
        PollService pollService = new PollService();
        PollModel poll = pollService.getPoll();

        assertThat(poll.getTitle()).isEqualTo("Default Poll");
    }

    @Test
    public void whenNoPollProvided_CreatesADefaultPoll_WithThreeItems_WithDescriptions() {
        PollService pollService = new PollService();
        PollModel poll = pollService.getPoll();
        List<PollItemModel> pollItems = poll.getPollItems();

        assertThat(pollItems).hasSize(3);
        for(int i = 0; i < pollItems.size(); i++) {
            assertThat(pollItems.get(i).getDescription()).isEqualTo(String.valueOf(i + 1));
        }
    }

    @Test
    public void whenNoPollProvided_CreatesADefaultPoll_WithThreeItems_WithIds() {
        PollService pollService = new PollService();
        PollModel poll = pollService.getPoll();
        List<PollItemModel> pollItems = poll.getPollItems();

        assertThat(pollItems).hasSize(3);
        for(int i = 0; i < pollItems.size(); i++) {
            assertThat(pollItems.get(i).getId()).isEqualTo(String.valueOf(i + 1));
        }
    }

    @Test
    public void whenPollItemIdIsPresentInPollItems_ReturnsPollItem(){
        PollService pollService = new PollService();
        PollItemModel pollItemModel = pollService.getPollItemById("1");
        PollItemModel expected = new PollItemModel();
        expected.setId("1");
        expected.setDescription("1");

        assertThat(pollItemModel).isEqualTo(expected);
    }

    @Test
    public void whenPollItemIdIsNotPresentInPollItems_ReturnsNull(){
        PollService pollService = new PollService();
        PollItemModel pollItemModel = pollService.getPollItemById("jabberwocky");
        assertThat(pollItemModel).isNull();
    }

}
