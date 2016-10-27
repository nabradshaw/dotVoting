package com.pillartechnology.academy.voting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
    public void testListControllerEndpointReturnsListOfStrings() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/list")).andReturn();
        String resultContent = result.getResponse().getContentAsString();

        if (!(resultContent.startsWith("[\"") && resultContent.endsWith("\"]") || resultContent.equals("[]"))) {
            fail("A list was not returned by the list endpoint");
        }
    }
}