package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "/servlets.Exo2Servlet", urlPatterns = "/")
public class Exo2Servlet extends HttpServlet {

    Map<String, Integer> counter = new HashMap<>();

    String choice = null;
    private final String[] options={"Beau","Couvert","Pluie","Neige"};


    @Override
    public void init(ServletConfig config) throws ServletException {
        for (String opt : options) {
            counter.put(opt, 0);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("meteo");
        choice = request.getParameter("meteo");
        //choice = option;
        int optionCount = counter.get(option);
        counter.put(option, optionCount+1);
        toJsp(request,response);
    }

    private void toJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("options",options);
        request.getSession().setAttribute("counter", counter);
        request.getSession().setAttribute("choice", choice);
        request.getRequestDispatcher("WEB-INF/meteo.jsp").forward(request,response);
    }
}
