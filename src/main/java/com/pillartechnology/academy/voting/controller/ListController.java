package com.pillartechnology.academy.voting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/list")
public class ListController {

    @RequestMapping(method = GET)
    public List<String> getVotingList() {
        List<String> result = new ArrayList<String>();
        result.add("A");
        result.add("B");
        result.add("C");
        result.add("D");
        return result;
    }
}
