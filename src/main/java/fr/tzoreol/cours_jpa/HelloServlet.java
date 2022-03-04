package fr.tzoreol.cours_jpa;

import fr.tzoreol.cours_jpa.entities.UsersEntity;

import java.io.*;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        UsersEntity user = em.createQuery("SELECT u FROM UsersEntity u", UsersEntity.class).getSingleResult();
        message = user.getUsername() + " is a " + user.getJob();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Username: " + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}