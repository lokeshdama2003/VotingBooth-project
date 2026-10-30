package com.voting.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ElectionRepository {

    public String getElectionStatus() {

        String status = "";

        String sql = "select status from election where election_id = 1";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                status = rs.getString("status");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean closeElection() {

        String sql = "update election set status = 'CLOSED' where election_id = 1";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean openElection() {

        String sql = "update election set status = 'OPEN' where election_id = 1";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}