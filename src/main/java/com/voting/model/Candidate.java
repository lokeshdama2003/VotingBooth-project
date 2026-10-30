package com.voting.model;

public class Candidate {

    private int canId;
    private String canName;
    private int voteCount;

    public Candidate() {
    }
    
    public Candidate(int canId, String canName, int voteCount) {
        this.canId = canId;
        this.canName = canName;
        this.voteCount = voteCount;
    }

    public int getCanId() {
        return canId;
    }

    public void setCanId(int canId) {
        this.canId = canId;
    }

    public String getCanName() {
        return canName;
    }

    public void setCanName(String canName) {
        this.canName = canName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}