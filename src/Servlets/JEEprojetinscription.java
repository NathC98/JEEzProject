package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.*;

@WebServlet(name = "JEEprojetinscription")
public class JEEprojetinscription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Player player = new Player();

        //récupération de la date actuelle.
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(actuelle);

        player.setDate("" + request.getParameter("date"));
        player.setEmail("" + request.getParameter("email"));
        player.setDateinscription("" + dat);
        player.inscription("" + request.getParameter("pseudo"), "" + request.getParameter("psw"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojet.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetinscription.jsp").forward(request,response);
    }
}
