package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PollServiceTest {

    @Test
    public void getPoll_RetrievesThePollFromAvailablePolls() {
        PollModel poll = new PollModel();
        poll.setId("12345");

        PollService pollService = new PollService(Arrays.asList(poll));
        PollModel actual = pollService.getPoll(poll.getId());

        assertThat(actual).isSameAs(poll);
    }

    @Test
    public void createPoll_SetThePollIdAndAddsNewPollToTheAvailablePolls() {
        PollModel poll = new PollModel();
        PollService pollService = new PollService();

        PollModel created = pollService.createPoll(poll);
        PollModel result = pollService.getPoll(created.getId());

        assertThat(created.getId()).isNotNull().isNotEmpty();
        assertThat(result).isSameAs(poll);
    }

    @Test
    public void createPoll_SetThePollIdsSequentiallyStartingAt0() {
        PollService pollService = new PollService();

        PollModel first = new PollModel();
        PollModel second = new PollModel();

        PollModel savedFirst = pollService.createPoll(first);
        PollModel savedSecond = pollService.createPoll(second);

        assertThat(savedFirst.getId()).isEqualTo("0");
        assertThat(savedSecond.getId()).isEqualTo("1");
    }

    @Test
    public void createPoll_SetsTheIdsForThePollItems() {
        PollModel expected = new PollModel();
        expected.setPollItems(Arrays.asList(new PollItemModel(), new PollItemModel(), new PollItemModel()));
        PollService pollService = new PollService();

        List<PollItemModel> items = pollService.createPoll(expected).getPollItems();

        for(int i = 0; i < items.size(); i++) {
            assertThat(items.get(i).getId()).isEqualTo(String.valueOf(i));
        }
    }

    @Test
    public void getPollItemById_whenPollItemIdIsPresentInPollItems_ReturnsPollItem(){
        PollService pollService = new PollService();

        PollItemModel expected = new PollItemModel();
        expected.setId("1");
        expected.setDescription("1");
        PollModel poll = new PollModel();
        poll.setPollItems(Arrays.asList(expected));
        pollService.createPoll(poll);

        PollItemModel actual = pollService.getPollItemById(expected.getId());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getPollItemById_whenPollItemIdIsNotPresentInPollItems_ReturnsNull(){
        PollService pollService = new PollService();
        PollItemModel pollItemModel = pollService.getPollItemById("jabberwocky");
        assertThat(pollItemModel).isNull();
    }

}
