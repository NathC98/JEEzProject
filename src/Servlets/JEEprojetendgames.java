package Servlets;

import AppClasses.Gestion_JEEz_JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JEEprojetendgames")
public class JEEprojetendgames extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
        request.setAttribute("plays",b.ListPlay());
        this.getServletContext().getRequestDispatcher("web/WEB-INF/JEEprojetendgames.jsp").forward(request,response);
    }
}
