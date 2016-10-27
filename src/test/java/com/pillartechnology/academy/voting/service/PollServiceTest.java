package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PollServiceTest {

    @Test
    public void get_RetrievesThePoll() {
        PollModel expected = new PollModel();
        PollService pollService = new PollService(expected);
        PollModel actual = pollService.get();
        assertThat(actual).isSameAs(expected);
    }


    @Test
    public void whenNoPollProvided_CreatesADefaultPoll_WithATitle() {
        PollService pollService = new PollService();
        PollModel poll = pollService.get();

        assertThat(poll.getTitle()).isEqualTo("Default Poll");
    }

    @Test
    public void whenNoPollProvided_CreatesADefaultPoll_WithThreeItems_WithDescriptions() {
        PollService pollService = new PollService();
        PollModel poll = pollService.get();
        List<PollItemModel> pollItems = poll.getPollItems();

        assertThat(pollItems).hasSize(3);
        for(int i = 0; i < pollItems.size(); i++) {
            assertThat(pollItems.get(i).getDescription()).isEqualTo(String.valueOf(i + 1));
        }
    }
}
