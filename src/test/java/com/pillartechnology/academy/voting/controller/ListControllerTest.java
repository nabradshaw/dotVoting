package com.pillartechnology.academy.voting.controller;


import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

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

        verify(service).savePoll(pollCaptor.capture());
        assertThat(pollCaptor.getValue()).isSameAs(expected);
    }

    @Test
    public void savePoll_SetsTheIdForThePoll() {
        PollModel expected = new PollModel();
        ArgumentCaptor<PollModel> pollCaptor = ArgumentCaptor.forClass(PollModel.class);

        uut.savePoll(expected);

        verify(service).savePoll(pollCaptor.capture());
        assertThat(pollCaptor.getValue().getId()).isEqualTo("1");
    }

    @Test
    public void savePoll_SetsTheIdsForThePollItems() {
        PollModel expected = new PollModel();
        expected.setPollItems(Arrays.asList(new PollItemModel(), new PollItemModel(), new PollItemModel()));
        ArgumentCaptor<PollModel> pollCaptor = ArgumentCaptor.forClass(PollModel.class);

        uut.savePoll(expected);

        verify(service).savePoll(pollCaptor.capture());

        List<PollItemModel> result = pollCaptor.getValue().getPollItems();
        for(int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getId()).isEqualTo(String.valueOf(i));
        }
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
