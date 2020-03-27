package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import AppClasses.*;
import java.util.*;

@WebServlet(name = "JEEprojetGAMECHOICE")
public class JEEprojetGAMECHOICE extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
        String id = request.getParameter("id");
        request.setAttribute("Identifiant", id);
        request.setAttribute("games",b.PlayableGame());
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetGAMECHOICE.jsp").forward(request,response);
    }
}
