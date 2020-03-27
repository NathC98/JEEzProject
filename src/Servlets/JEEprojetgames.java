package Servlets;

import AppClasses.Gestion_JEEz_JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JEEprojetgames")
public class JEEprojetgames extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gestion_JEEz_JDBC gestionnaire = new Gestion_JEEz_JDBC();
        String answerplay = request.getParameter("playable");
        boolean playable = new boolean();
        
        if(answerplay == "yes"){playable = true;}
        else if(answerplay == "no"){playable = false;}
        else{this.getServletContext().getRequestDispatcher("web/WEB-INF/JEEprojetgames.jsp").forward(request,response);}

        gestionnaire.insertGame("" + request.getParameter("gname"), playable);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
        request.setAttribute("games",b.PlayableGame());
        this.getServletContext().getRequestDispatcher("web/WEB-INF/JEEprojetgames.jsp").forward(request,response);
    }
}
