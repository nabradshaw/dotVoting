package com.pillartechnology.academy.voting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pillartechnology.academy.voting.model.PollItemModel;
import com.pillartechnology.academy.voting.model.PollModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ListControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListControllerEndpointReturnsOkStatus() throws Exception {
        mockMvc.perform(get("/api/list")).andExpect(status().isOk());
    }

    @Test
    public void testListControllerEndpointReturnsPollModel() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/list")).andReturn();

        ObjectMapper mapper = new ObjectMapper();
        PollModel model = mapper.readValue(result.getResponse().getContentAsByteArray(), PollModel.class);

        PollModel expected = new PollModel();
        expected.setId("newId1");
        expected.setTitle("New Test Poll");

        PollItemModel expectedItem1 = new PollItemModel();
        expectedItem1.setId("Item1");
        expectedItem1.setDescription("The first item to vote on");

        PollItemModel expectedItem2 = new PollItemModel();
        expectedItem2.setId("Item2");
        expectedItem2.setDescription("The second item to vote on");

        List<PollItemModel> expectedItems = new ArrayList<PollItemModel>();
        expectedItems.add(expectedItem1);
        expectedItems.add(expectedItem2);

        expected.setPollItems(expectedItems);

        assertEquals(expected, model);
    }
}