package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import AppClasses.*;
import java.util.*;
import java.text.*;

@WebServlet(name = "JEEprojetinscription")
public class JEEprojetinscription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Gestion_JEEz_JDBC gestionnaire = new Gestion_JEEz_JDBC();

        //récupération de la date actuelle.
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(actuelle);

        //insertion du joueur dans la base de donnée à partir du gestionnaire.
        gestionnaire.InsertPlayer("" + request.getParameter("pseudo"), "" + request.getParameter("psw"),
                "" + request.getParameter("date"), "" + request.getParameter("email"), "" + dat);

        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojet.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetinscription.jsp").forward(request,response);
    }
}
