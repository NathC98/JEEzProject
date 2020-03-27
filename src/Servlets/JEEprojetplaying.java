package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import AppClasses.*;
import java.util.Date;

@WebServlet(name = "JEEprojetplaying")
public class JEEprojetplaying extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
        int idjoueur = Integer.parseInt((String)request.getParameter("id"));
        int idjeu = Integer.parseInt((String)request.getParameter("idgame"));
        request.setAttribute("Identifiant", idjoueur);
        request.setAttribute("Idjeu", idjeu);
        Date d = new Date();
        int idgame =  b.insertPlay(d.toString(),idjoueur,idjeu);
        request.setAttribute("games",b.PlayableGame());
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetplaying.jsp").forward(request,response);
    }
}
