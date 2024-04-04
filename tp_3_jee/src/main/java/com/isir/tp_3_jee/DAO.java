package com.isir.tp_3_jee;

import com.isir.tp_3_jee.bean.Livre;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private Connection con;
    private Statement statement;

    public void LoidDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3", "root", "");

        return con;
    }

    public void saveLivre(String isbn, String titre, String auteur, int nbrPage) throws SQLException {
        statement = con.createStatement();
        String query = "INSERT INTO livres (isbn, titre, auteur, nbrPage) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, isbn);
            statement.setString(2, titre);
            statement.setString(3, auteur);
            statement.setInt(4, nbrPage);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted == 0) {
                throw new SQLException("Failed to insert book into database");
            }
            con.close();
        }
    }

    public ArrayList<Livre> getLivres() throws SQLException {
        statement = con.createStatement();
        ArrayList livres = new ArrayList<Livre>();
        ResultSet res = statement.executeQuery("select * from livres");
        while(res.next()){
            Livre l = new Livre();
            l.setIsbn(res.getString("isbn"));
            l.setAuteur(res.getString("auteur"));
            l.setTitre(res.getString("titre"));
            l.setNbrPage(res.getInt("nbrPage"));
            livres.add(l);
        }
        con.close();
        return livres;
    }
}

