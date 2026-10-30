package com.voting.repository;

import com.voting.model.Voter;

public class TestVoter {

    public static void main(String[] args) {

        VoterRepository repository = new VoterRepository();

        Voter voter = repository.getVoterById(101);

        if (voter != null) {

            System.out.println("Voter Found!");
            System.out.println("Voter ID: " + voter.getVoterId());
            System.out.println("Voter Name: " + voter.getVoterName());
            System.out.println("Has Voted: " + voter.isHasVoted());

        } else {

            System.out.println("Voter not found.");
        }
    }
}