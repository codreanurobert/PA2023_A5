package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        // TODO
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
