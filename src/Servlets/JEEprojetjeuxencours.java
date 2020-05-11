package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AppClasses.Gestion_JEEz_JDBC;

import java.io.IOException;

@WebServlet(name = "JEEprojetjeuxencours")
public class JEEprojetjeuxencours extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Gestion_JEEz_JDBC b = new Gestion_JEEz_JDBC();
        request.setAttribute("plays",b.ListPlayer());
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetjeuxencours.jsp").forward(request,response);
    }
}
