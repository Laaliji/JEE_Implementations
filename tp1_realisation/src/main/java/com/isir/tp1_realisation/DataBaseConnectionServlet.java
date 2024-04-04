package com.isir.tp1_realisation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;

@WebServlet(name = "databaseConnection", urlPatterns = {"/databaseConnection"})

public class DataBaseConnectionServlet extends HttpServlet {
    private String nom;
    private Connection con;
    Statement smt;

    public void init(ServletConfig config) {
        try {
            super.init(config);
            ServletContext conf = getServletContext();
            Class.forName(conf.getInitParameter("classDriver"));
            con = DriverManager.getConnection(conf.getInitParameter("chemin"), "root", "");
            smt = con.createStatement();
            nom = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void Auth(String login, String password) throws SQLException {
        this.nom = null;
        ResultSet resultat = smt.executeQuery("select * from utilisateur where Login ='" + login + "' AND Password = '" + password + "'");
        while (resultat.next()) {
            this.nom = resultat.getString("Nom");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String login = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");
        try {
            Auth(login, password);
            if (nom != null) {
                out.println("<html>");
                out.println("<head><title>login page</title></head>");
                out.println("");
                out.println("<body>");
                out.println("<h1>bonjour " + nom + "</h1>");
                out.println("</body>");
                out.println("</html>");
            } else {
                req.setAttribute("erreur", "login ou mot de pass est incorrect");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/partie2.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
