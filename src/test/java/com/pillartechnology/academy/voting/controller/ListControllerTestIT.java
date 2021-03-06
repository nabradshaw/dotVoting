package com.pillartechnology.academy.voting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import com.pillartechnology.academy.voting.service.PollService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ListControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PollService pollService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getPoll_ReturnsOkStatus() throws Exception {
        mockMvc.perform(get("/api/poll/1")).andExpect(status().isOk());
    }

    @Test
    public void getPoll_ReturnsTheRequestedPoll() throws Exception {
        PollModel poll = new PollModel();
        PollModel savedPoll = pollService.createPoll(poll);
        MvcResult result = mockMvc.perform(get("/api/poll/" + savedPoll.getId())).andReturn();
        PollModel actual = mapper.readValue(result.getResponse().getContentAsByteArray(), PollModel.class);

        assertThat(actual).isEqualTo(savedPoll);
    }

    @Test
    public void savePoll_SavesThePoll() throws Exception {
        PollModel poll = new PollModel();
        poll.setTitle("My Title");

        String pollToPost = mapper.writeValueAsString(poll);
        mockMvc.perform(post("/api/poll")
                .contentType(APPLICATION_JSON)
                .content(pollToPost))
                .andExpect(status().isOk());

    }

    @Test
    public void getPoll_RequestUniquePoll() throws Exception {
        PollModel poll1 = new PollModel();
        PollModel poll2 = new PollModel();
        poll1.setTitle("First Title");
        poll2.setTitle("Second Title");
        
        PollModel firstSavedPoll = pollService.createPoll(poll1);
        pollService.createPoll(poll2);
        
        MvcResult result = mockMvc.perform(get("/api/poll/" + firstSavedPoll.getId())).andReturn();
        PollModel actual = mapper.readValue(result.getResponse().getContentAsByteArray(), PollModel.class);
        
        assertThat(actual).isEqualTo(firstSavedPoll);
    }    
}