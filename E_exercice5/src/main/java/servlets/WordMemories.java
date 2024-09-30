package servlets;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/")
public class WordMemories extends HttpServlet {

    List<String> messages = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/saisi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todo = req.getParameter("todo");
        String message;
        switch (todo) {
            case "ajout":
                message = req.getParameter("message");
                messages.add(message);
                req.getRequestDispatcher("/WEB-INF/saisi.jsp").forward(req, resp);
                break;
            case "affichage":
                message = req.getParameter("message");
                messages.add(message);
                affichage(true,req,resp);
                break;
            case "random":
                affichage(true,req,resp);
                break;
            case "all" :
                affichage(false,req,resp);
                break;

        }
    }

    private void affichage(boolean random,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("random", random);

        if (random) {
            Random rand = new Random();
            int randomNum = rand.nextInt(messages.size());
            String message = messages.get(randomNum);
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/affichage.jsp").forward(req, resp);
        }

        Set<String> list = new HashSet<>(messages);
        req.setAttribute("messages", list);
        req.getRequestDispatcher("/WEB-INF/affichage.jsp").forward(req, resp);
    }
}
