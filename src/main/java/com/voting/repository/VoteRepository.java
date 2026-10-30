package com.voting.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoteRepository {

    public int castVote(int voterId, int candidateId) {

        int voteId = 0;
        Connection con = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);
            String insertVote ="insert into votes (voter_id, can_id) values (?, ?)";

            PreparedStatement ps1 = con.prepareStatement(insertVote,PreparedStatement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, voterId);
            ps1.setInt(2, candidateId);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();

            if (rs.next()) {
                voteId = rs.getInt(1);
            }
            
            String updateVoter = "update voter " + "set has_voted = true " + "where voter_id = ?";
            PreparedStatement ps2 = con.prepareStatement(updateVoter);
            ps2.setInt(1, voterId);
            ps2.executeUpdate();

            String updateCandidate ="update candidate " + "set vote_count = vote_count + 1 " + "where can_id = ?";

            PreparedStatement ps3 = con.prepareStatement(updateCandidate);
            ps3.setInt(1, candidateId);
            ps3.executeUpdate();
            con.commit();
            System.out.println("Vote recorded successfully");
            rs.close();
            ps1.close();
            ps2.close();
            ps3.close();

        } catch (Exception e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

            voteId = 0;
        }
        return voteId;
    }
}