package com.pillartechnology.academy.voting.model;

public class PollItemModel {
    private String id;
    private int voteCount;
    private String description;

    public PollItemModel() {
        voteCount = 0;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public synchronized void alterVoteCount(int amount) {
        voteCount += amount;
        if(voteCount < 0) {
            voteCount = 0;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollItemModel that = (PollItemModel) o;

        if (voteCount != that.voteCount) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + voteCount;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
