package com.voting.model;

public class Voter {

    private int voterId;
    private String voterName;
    private boolean hasVoted;

    public Voter() {
    }

    public Voter(int voterId, String voterName, boolean hasVoted) {
        this.voterId = voterId;
        this.voterName = voterName;
        this.hasVoted = hasVoted;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}