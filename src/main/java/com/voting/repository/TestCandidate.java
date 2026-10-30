package com.voting.repository;

import java.util.List;

import com.voting.model.Candidate;

public class TestCandidate {

    public static void main(String[] args) {

        CandidateRepository repository = new CandidateRepository();

        List<Candidate> candidates =
                repository.getAllCandidates();

        System.out.println("===== CANDIDATES =====");

        for (Candidate candidate : candidates) {

            System.out.println(
                    "ID: " + candidate.getCanId()
                    + " | Name: " + candidate.getCanName()
                    + " | Votes: " + candidate.getVoteCount()
            );
        }
    }
}