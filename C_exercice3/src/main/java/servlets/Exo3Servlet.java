package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {
    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants;

    private String msg = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait au premier appel

        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait pour les appels suivants...
        if (aDeviner==null) {
            String mot = request.getParameter("lemot");
            setaDeviner(mot);
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }

        String choice = request.getParameter("lecaractere");
        if (choice.length()<1) {
            msg = "Il faut saisir un caractère";
            request.getSession().setAttribute("msg", msg);
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        } else if(choice.length()>1) {
            msg = "Il faut saisir un seul caractère";
            request.getSession().setAttribute("msg", msg);
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }

        char carac = (request.getParameter("lecaractere")).charAt(0);
        jouer(carac, request, response);

    }


    private void setaDeviner(String aDeviner) {
        this.aDeviner=aDeviner;
        this.devine=new StringBuilder("_".repeat(aDeviner.length()));
        this.nbEssaisRestants=10;
    }

    private boolean test(char carac){
        boolean res=false;
        for (int last=aDeviner.indexOf(carac);last!=-1;last=aDeviner.indexOf(carac,last+1)) {
            res = true;
            devine.setCharAt(last, carac);
        }
        if (!res) {
            nbEssaisRestants--;
        }
        return res;
    }


    private void jouer(char choice, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean res = test(choice);
        if (nbEssaisRestants<=0) {
            msg = "Vous avez perdu!!!! Le mot est " + aDeviner + "!!! Reprennez encore et vous y arriverez";
            request.getSession().setAttribute("msg", msg);
            request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request, response);
        }

        if (res) {

            if (aDeviner.contentEquals(devine)) {
                msg = "Félicitation, vous avez trouvé le mot : " + aDeviner + ". Si vous voulez reprendre, saisissez un nouveau mot et jouer";
                request.getSession().setAttribute("msg", msg);
                request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request, response);
            }

            msg = "Vous avez trouvé le caractère <<"+choice+">>. Continuer comme ça et vous trouverez le mot en entier.";
            request.getSession().setAttribute("msg", msg);
            request.setAttribute("devine", devine);
            request.setAttribute("nbEssai", nbEssaisRestants);
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }

        msg = "Vous n'avez trouvé le caractère précedent";
        request.getSession().setAttribute("msg", msg);
        request.setAttribute("devine", devine);
        request.setAttribute("nbEssai", nbEssaisRestants);
        request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
    }


}
