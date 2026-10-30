package com.voting.model;

public class Vote {

    private int voteId;
    private int voterId;
    private int canId;

    public Vote() {
    }

    public Vote(int voteId, int voterId, int canId) {
        this.voteId = voteId;
        this.voterId = voterId;
        this.canId = canId;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getCanId() {
        return canId;
    }

    public void setCanId(int canId) {
        this.canId = canId;
    }
}