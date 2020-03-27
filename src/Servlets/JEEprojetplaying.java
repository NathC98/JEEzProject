package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import AppClasses.*;

@WebServlet(name = " JEEprojetplaying")
public class JEEprojet extends HttpServlet {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/*
	Cette procédure permet l'authentification, et autorise ou non un joueur ou un administrateur à se connecter au site.
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetplaying.jsp").forward(request,response);
    }
}
