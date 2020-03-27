package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import AppClasses.*;

@WebServlet(name = " JEEprojet")
public class JEEprojet extends HttpServlet {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Identifiant id = new Identifiant();
        String login  = request.getParameter("uname");
        String psw = request.getParameter("psw");
        id.connexion(login,psw);

        if (id.getAdmin() == 0){
            request.setAttribute("Identifiant", "" + id.getIdIdentifiant());
            this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetGAMECHOICE.jsp").forward(request,response);
        }
        else if (id.getAdmin() == 1){
            request.setAttribute("Identifiant", "" + id.getIdIdentifiant());
            this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetaccueiladmin.jsp").forward(request,response);
        }
        else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojet.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojet.jsp").forward(request,response);
    }
}
