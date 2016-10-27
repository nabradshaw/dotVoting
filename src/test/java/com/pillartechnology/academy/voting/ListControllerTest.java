package com.pillartechnology.academy.voting;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListControllerTest {
    ListController uut;

    @Test
    public void ensureEndpointReturnsABCDWhenCalled() {
        uut = new ListController();
        List<String> expected = new ArrayList<String>();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("D");
        assertEquals(expected, uut.getVotingList());
    }
}
