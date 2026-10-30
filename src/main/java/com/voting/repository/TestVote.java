package com.voting.repository;

public class TestVote {

    public static void main(String[] args) {

        VoteRepository repository = new VoteRepository();

        int voteId = repository.castVote(101, 2);

        System.out.println("Generated Vote ID: " + voteId);
    }
}