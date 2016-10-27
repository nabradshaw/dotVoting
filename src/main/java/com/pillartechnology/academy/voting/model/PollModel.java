package com.pillartechnology.academy.voting.model;

import java.util.List;

public class PollModel {
    private String id;
    private String title;
    private List<PollItemModel> pollItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PollItemModel> getPollItems() {
        return pollItems;
    }

    public void setPollItems(List<PollItemModel> pollItems) {
        this.pollItems = pollItems;
    }
}
