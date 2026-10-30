package com.voting.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.voting.model.Candidate;

public class CandidateRepository {

    public List<Candidate> getAllCandidates() {

        List<Candidate> candidates = new ArrayList<Candidate>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from candidate";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Candidate candidate = new Candidate();

                candidate.setCanId(rs.getInt("can_id"));
                candidate.setCanName(rs.getString("can_name"));
                candidate.setVoteCount(rs.getInt("vote_count"));

                candidates.add(candidate);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return candidates;
    }
}