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
    public void createPoll_SetsTheIdsForThePollItemsToUniqueValues() {
        PollModel firstPoll = new PollModel();
        firstPoll.setPollItems(Arrays.asList(new PollItemModel(), new PollItemModel()));
        PollModel secondPoll = new PollModel();
        secondPoll.setPollItems(Arrays.asList(new PollItemModel(), new PollItemModel()));

        PollService pollService = new PollService();
        PollModel savedFirstPoll = pollService.createPoll(firstPoll);
        PollModel savedSecondPoll = pollService.createPoll(secondPoll);

        assertThat(savedFirstPoll.getPollItems().get(0).getId()).isEqualTo("0");
        assertThat(savedFirstPoll.getPollItems().get(1).getId()).isEqualTo("1");
        assertThat(savedSecondPoll.getPollItems().get(0).getId()).isEqualTo("2");
        assertThat(savedSecondPoll.getPollItems().get(1).getId()).isEqualTo("3");
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
