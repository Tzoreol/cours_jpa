package fr.tzoreol.cours_jpa;

import fr.tzoreol.cours_jpa.entities.MesssageEntity;
import fr.tzoreol.cours_jpa.entities.PasswordEntity;
import fr.tzoreol.cours_jpa.entities.RoleEntity;
import fr.tzoreol.cours_jpa.entities.UsersEntity;

import java.io.*;
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

        PasswordEntity password = new PasswordEntity();
        password.setPassword("Password0!");

        RoleEntity role = new RoleEntity();
        role.setName("ADMIN");

        UsersEntity user = new UsersEntity();
        user.setLogin("Tzoreol");
        user.setPassword(password);
        user.setRole(role);

        MesssageEntity messsage = new MesssageEntity();
        messsage.setUser(user);
        messsage.setMessage("Hello, world!");

        em.getTransaction().begin();
        em.persist(password);
        em.persist(role);
        em.persist(user);
        em.persist(messsage);
        em.getTransaction().commit();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Username: " + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}