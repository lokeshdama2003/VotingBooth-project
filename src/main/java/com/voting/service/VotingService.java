package com.voting.service;

import com.voting.model.Voter;
import com.voting.repository.VoterRepository;
import com.voting.repository.VoteRepository;

public class VotingService {

    private VoterRepository voterRepository;
    private VoteRepository voteRepository;

    public VotingService() {

        voterRepository = new VoterRepository();
        voteRepository = new VoteRepository();
    }
    public int castVote(int voterId, int candidateId) {
        Voter voter = voterRepository.getVoterById(voterId);

        if (voter == null) {
            return -2;
        }
        if (voter.isHasVoted()) {
            return -1;
        }
        return voteRepository.castVote(
                voterId,
                candidateId);
    }
}