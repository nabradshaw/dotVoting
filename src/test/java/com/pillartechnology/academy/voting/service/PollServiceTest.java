package com.pillartechnology.academy.voting.service;

import com.pillartechnology.academy.voting.model.PollModel;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PollServiceTest {

    @Test
    public void get_RetrievesThePoll() {
        PollModel expected = new PollModel();
        PollService pollService = new PollService(expected);
        PollModel actual = pollService.get();
        assertThat(actual).isSameAs(expected);
    }

}
