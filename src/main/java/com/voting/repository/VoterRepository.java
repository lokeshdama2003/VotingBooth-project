package com.voting.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.voting.model.Voter;

public class VoterRepository {

    public Voter getVoterById(int voterId) {

        Voter voter = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from voter where voter_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, voterId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                voter = new Voter();
                voter.setVoterId(rs.getInt("voter_id"));
                voter.setVoterName(rs.getString("voter_name"));
                voter.setHasVoted(rs.getBoolean("has_voted"));
            }
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return voter;
    }

    public int getTotalVoters() {
        int total = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "select count(*) from voter";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return total;
    }

    public int getTotalVotes() {
        int total = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select count(*) from votes";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                total = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}