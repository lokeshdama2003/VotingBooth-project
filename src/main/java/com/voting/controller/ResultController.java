package com.voting.controller;

import java.io.IOException;
import java.util.List;

import com.voting.model.Candidate;
import com.voting.repository.CandidateRepository;
import com.voting.repository.ElectionRepository;
import com.voting.repository.VoterRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/results")
public class ResultController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CandidateRepository candidateRepository;
    private VoterRepository voterRepository;
    private ElectionRepository electionRepository;

    @Override
    public void init() {
        candidateRepository = new CandidateRepository();
        voterRepository = new VoterRepository();
        electionRepository = new ElectionRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

        String status = electionRepository.getElectionStatus();

        List<Candidate> candidates = candidateRepository.getAllCandidates();

        int totalVoters = voterRepository.getTotalVoters();

        int votesCast = voterRepository.getTotalVotes();

        double turnout = 0;

        if (totalVoters > 0) {
            turnout = ((double) votesCast / totalVoters) * 100;
        }

        request.setAttribute("status", status);
        request.setAttribute("candidates", candidates);
        request.setAttribute("totalVoters", totalVoters);
        request.setAttribute("votesCast", votesCast);
        request.setAttribute("turnout", String.format("%.2f", turnout));

        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}