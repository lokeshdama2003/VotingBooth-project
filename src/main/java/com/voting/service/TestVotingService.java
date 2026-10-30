package com.voting.service;

public class TestVotingService {

    public static void main(String[] args) {

        VotingService service = new VotingService();

        int voteId = service.castVote(102,2);

        

            System.out.println("=========================");
            System.out.println("Eligible:" + voteId);
            System.out.println("=========================");
        }
    }
