package com.voting.controller;

import java.io.IOException;

import com.voting.repository.ElectionRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/closeVoting")
public class CloseVotingController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ElectionRepository electionRepository;

    @Override
    public void init() {
        electionRepository = new ElectionRepository();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        boolean closed = electionRepository.closeElection();

        if (closed) {
            response.sendRedirect("results");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}