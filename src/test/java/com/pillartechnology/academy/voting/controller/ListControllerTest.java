package com.pillartechnology.academy.voting.controller;


import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
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

    @Test
    public void savePoll_SavesTheCorrectPoll() {
        PollModel expected = new PollModel();
        ArgumentCaptor<PollModel> pollCaptor = ArgumentCaptor.forClass(PollModel.class);

        uut.savePoll(expected);

        verify(service).createPoll(pollCaptor.capture());
        assertThat(pollCaptor.getValue()).isSameAs(expected);
    }

    @Test
    public void getPoll_returnsPollForProvidedID(){
        PollModel expected = new PollModel();
        expected.setId("Id1");

        when(service.getPoll(expected.getId())).thenReturn(expected);

        PollModel result = uut.getPoll("Id1");
        assertThat(result).isSameAs(expected);
    }

}
