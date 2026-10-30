package com.voting.controller;

import java.io.IOException;

import com.voting.service.VotingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vote")
public class VotingController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private VotingService votingService;

    public VotingController() {
        votingService = new VotingService();
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

        int voterId;
        int candidateId;

        try {

            voterId = Integer.parseInt(request.getParameter("voterId"));
            candidateId = Integer.parseInt(request.getParameter("candidateId"));

        } catch (Exception e) {
            response.sendRedirect("vote.html");
            return;
        }
        int voteId = votingService.castVote(
                voterId, candidateId);
        if (voteId > 0) {
            String partyName;

            if (candidateId == 1) {
                partyName = "TDP";
            } else {
                partyName = "YSRCP";
            }

            request.setAttribute("voterId", voterId);
            request.setAttribute("candidateId", candidateId);
            request.setAttribute("partyName", partyName);
            request.setAttribute("voteId", voteId);

            request.getRequestDispatcher("vote-success.jsp").forward(request, response);
        } else if (voteId == -1) {
            request.getRequestDispatcher("duplicate-vote.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}