package com.isir.tp1_realisation;

import java.io.*;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "MaServlet",value = {"/login"})
public class MaServlet extends HttpServlet {
    private HashMap<String, String> users;


    public void init() {
        users = new HashMap<String , String>();
        users.put("est" , "1234");
    }

    public boolean Auth(String nom , String password){
        return users.containsKey(nom) && users.get(nom).equals(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String nom = (String) req.getParameter("nom");
        String password = (String) req.getParameter("password");


        if(Auth(nom , password)){
            out.println("<html>");
            out.println("<head><title>login page</title></head>");
            out.println("");
            out.println("<body>");
            out.println("<h1>bonjour " + nom + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }else{
            req.setAttribute("erreur" , "login ou mot de pass est incorrect");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/partie1.jsp");
            dispatcher.forward(req, resp);
        }

    }

    public void destroy() {
    }
}