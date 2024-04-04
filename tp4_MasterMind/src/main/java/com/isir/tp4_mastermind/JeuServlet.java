package com.isir.tp4_mastermind;

import com.isir.tp4_mastermind.metier.Jeu;
import com.isir.tp4_mastermind.web.JeuBean;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "JeuServlet", urlPatterns = {"JeuServlet"})
public class JeuServlet extends HttpServlet {
    private Jeu jeu;

    @Override
    public void init() throws ServletException {
        jeu = new Jeu();
        jeu.lancerJeu();
        jeu.genererNbr();
        jeu.setGame(1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String submit = req.getParameter("status");
        HttpSession session = req.getSession();
        JeuBean monBean;
        if (Objects.equals(submit, "Reinitialiser le jeu")) {
            jeu.lancerJeu();
            jeu.genererNbr();
            jeu.setGame(jeu.getGame() + 1);
            if (session.getAttribute("bean") != null) {
                monBean = (JeuBean) session.getAttribute("bean");
                monBean.getLstMessages().clear();
                req.setAttribute("bean", monBean);
            }
            req.setAttribute("end", jeu.isEnd());
            req.setAttribute("game", jeu.getGame());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            if (!req.getParameter("numJeu").isEmpty() && Integer.parseInt(req.getParameter("numJeu")) != jeu.getGame()) {
                System.out.println("new game");
                if (session.getAttribute("bean") != null) {
                    monBean = (JeuBean) session.getAttribute("bean");
                    monBean.getLstMessages().clear();
                    req.setAttribute("bean", monBean);
                }
                req.setAttribute("nvgame", true);
                req.setAttribute("game", jeu.getGame());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                if (jeu.isEnd()) {
                    if (session.getAttribute("bean") != null) {
                        monBean = (JeuBean) session.getAttribute("bean");
                        monBean.getLstMessages().clear();
                        req.setAttribute("bean", monBean);
                    }
                    req.setAttribute("end", jeu.isEnd());
                    req.setAttribute("game", jeu.getGame());
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } else {
                    int nbPropose;
                    nbPropose = Integer.parseInt(req.getParameter("nbr"));
                    if (session.getAttribute("bean") != null) {
                        monBean = (JeuBean) session.getAttribute("bean");
                    } else {
                        monBean = new JeuBean();
                    }
                    monBean.setNbr(nbPropose);
                    monBean.getLstMessages().add(jeu.jouer(nbPropose));
                    int lastIndex = monBean.getLstMessages().size() - 1;
                    if (Objects.equals(monBean.getLstMessages().get(lastIndex), "Bravo!! vous avez réussi")) {
                        jeu.fermerJeu();
                    }
                    req.setAttribute("bean", monBean);
                    req.setAttribute("end", jeu.isEnd());
                    req.setAttribute("game", jeu.getGame());
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }
        }
    }
}
