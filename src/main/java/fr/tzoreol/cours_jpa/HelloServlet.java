package fr.tzoreol.cours_jpa;

import fr.tzoreol.cours_jpa.entities.UserPK;
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

        UserPK userPK = new UserPK();
        userPK.setFirstname("Alice");
        userPK.setLastname("Adams");

        UsersEntity users = em.find(UsersEntity.class, userPK);
        message = "User is " + users.getUserPK().getFirstname() + " " + users.getUserPK().getLastname();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Username: " + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}