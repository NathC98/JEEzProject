package Servlets;

import AppClasses.Gestion_JEEz_JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "JEEprojetended")
public class JEEprojetended extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
        String idjoueur = request.getParameter("id");
        String idjeu = request.getParameter("idjeu");
        Date end = new Date ();
        b.updatePlay(idjeu,end);
        request.setAttribute("games",b.PlayableGame());
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetplaying.jsp").forward(request,response);
    }
}
