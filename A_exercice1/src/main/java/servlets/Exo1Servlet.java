package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Exo1Servlet extends HttpServlet {

    private String hamir = "hamir";
    private String sougoumay = "sougoumay";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.equals(hamir) && password.equals(sougoumay)) {
            request.setAttribute("login", hamir);
            request.setAttribute("password", sougoumay);
            request.getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
        }
        request.setAttribute("message", "Le login et le password sont obligatoire");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }
}
