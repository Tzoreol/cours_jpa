package fr.tzoreol.cours_jpa;

import fr.tzoreol.cours_jpa.entities.MesssageEntity;
import fr.tzoreol.cours_jpa.entities.PasswordEntity;
import fr.tzoreol.cours_jpa.entities.UsersEntity;
import fr.tzoreol.cours_jpa.enums.Role;

import java.io.*;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("fr.tzoreol.entities.Users.getUsersAndMessages");
        query.setParameter("login", "Tzoreol");

        List results = query.getResultList();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<ul>");

        results.forEach(l -> out.println("<li>" + l.getClass().toString() + "</li>"));

        out.println("</ul>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}