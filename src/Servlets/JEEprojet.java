package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = " JEEprojet")
public class JEEprojet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Identifiant id = new Identifiant();
        String login  = request.getParameter("uname");
        String psw = request.getParameter("psw");
        id.connexion(login,psw);
        if (id.getAdmin() == 0){
            JEEprojetGAMECHOICE nouvservlet = new JEEprojetGAMECHOICE();
            nouvservlet.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetGAMECHOICE.jsp?id="+id.getidIdentifiant().toString()).forward(request,response);
        }else{
            JEEprojetaccueiladmin nouvservlet = new JEEprojetaccueiladmin();
            nouvservlet.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetaccueiladmin.jsp?id="+id.getidIdentifiant().toString()).forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojet.jsp").forward(request,response);
    }
}
