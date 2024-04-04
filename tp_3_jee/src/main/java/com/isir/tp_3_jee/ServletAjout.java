package com.isir.tp_3_jee;

import com.isir.tp_3_jee.bean.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletAjout", urlPatterns = {"ServletAjout"})
public class ServletAjout extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        livres.add((Livre)request.getAttribute("monLivre"));
//        request.setAttribute("mesLivres", livres);
//        request.getRequestDispatcher("livres.jsp").forward(request, response);
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DAO dao = new DAO();
            dao.LoidDriver();
            dao.getConnection();

            ArrayList<Livre> livres;
            Livre l = (Livre) request.getAttribute("monLivre");
            l.enregistrer();
            livres = dao.getLivres();
            request.setAttribute("mesLivres", livres);
            request.getRequestDispatcher("livres.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
