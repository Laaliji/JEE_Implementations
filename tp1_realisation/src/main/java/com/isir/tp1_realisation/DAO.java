package com.isir.tp1_realisation;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private Connection con;
    private Statement smt;

    public void LoidDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp1_servlet", "root", "");
        return con;
    }

    boolean authentification(String login, String password) throws SQLException {
        ResultSet resultat = smt.executeQuery("select * from utilisateur where Login ='" + login + "' AND Password = '" + password + "'");
        while (resultat.next()) {
            return true;
        }
        return false;
    }

    ArrayList listeUsers() throws SQLException {
        ArrayList<String> users = new ArrayList<String>();
        ResultSet resultat = smt.executeQuery("select * from utilisateur");
        while (resultat.next()) {
            users.add(resultat.getString("Nom"));
        }
        return users;
    }

}
