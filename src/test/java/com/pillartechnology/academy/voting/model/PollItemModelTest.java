package com.pillartechnology.academy.voting.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PollItemModelTest {

    @Test
    public void alterVoteCount_WhenGivenAPositiveNumber_IncrementsTheVoteCount() {
        PollItemModel item = new PollItemModel();

        item.alterVoteCount(5);
        assertThat(item.getVoteCount()).isEqualTo(5);
    }

    @Test
    public void alterVoteCount_WhenGivenANegativeNumber_DecrementsTheVoteCount() {
        PollItemModel item = new PollItemModel();
        item.alterVoteCount(5);
        item.alterVoteCount(-3);

        assertThat(item.getVoteCount()).isEqualTo(2);
    }

    @Test
    public void alterVoteCount_DoesNotAllowTheVoteCountToGoBelowZero() {
        PollItemModel item = new PollItemModel();
        item.alterVoteCount(5);
        item.alterVoteCount(-6);

        assertThat(item.getVoteCount()).isEqualTo(0);
    }
}