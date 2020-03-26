package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/JEEprojetgames")
public class JEEprojetgames extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Gestion_JEEz_JDBC jdbc = new Gestion_JEEz_JDBC();

    public JEEprojetgames() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("games", jdbc.PlayableGames());
        this.getServletContext().getRequestDispatcher("/WEB-INF/JEEprojetgames.jsp").forward(request,response);
    }
}
