package com.pillartechnology.academy.voting.model;

public class PollItemModel {
    private String id;
    private int voteCount;
    private String description;

    public int getVoteCount() {
        return voteCount;
    }

    public synchronized void alterVoteCount(int amount) {
        this.voteCount += amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
