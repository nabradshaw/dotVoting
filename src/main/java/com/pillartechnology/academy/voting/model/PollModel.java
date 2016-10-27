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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollModel pollModel = (PollModel) o;

        if (id != null ? !id.equals(pollModel.id) : pollModel.id != null) return false;
        if (title != null ? !title.equals(pollModel.title) : pollModel.title != null) return false;
        return pollItems != null ? pollItems.equals(pollModel.pollItems) : pollModel.pollItems == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (pollItems != null ? pollItems.hashCode() : 0);
        return result;
    }
}
