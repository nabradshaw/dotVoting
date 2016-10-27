package com.pillartechnology.academy.voting.controller;


import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ListControllerTest {

    @InjectMocks
    ListController uut;

    @Mock
    private PollService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPoll_ReturnsCorrectPoll() {
        PollModel expected = new PollModel();
        when(service.getPoll()).thenReturn(expected);

        PollModel result = uut.getPoll();
        assertThat(result).isSameAs(expected);
    }
}
