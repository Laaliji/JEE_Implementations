package com.isir.tp1_realisation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "partie3", urlPatterns = {"partie3"})
public class ServletPartie3 extends HttpServlet {
    private DAO dao;
    private Connection con;

    @Override
    public void init() throws ServletException {
        try {
            dao = new DAO();
            dao.LoidDriver();
            con = dao.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String login = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");


        try {
            if(dao.authentification(login,password)){
                ArrayList users = dao.listeUsers();
                out.println("<html>");
                out.println("<head><title>login page</title></head>");
                out.println("");
                out.println("<body>");
                out.println("<h1>bonjour</h1>");
                users.forEach(user -> out.println("<div>" + user + "</div>"));
                out.println("</body>");
                out.println("</html>");
            }else{
                req.setAttribute("erreur" , "login ou mot de pass est incorrect");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/partie3.jsp");
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
