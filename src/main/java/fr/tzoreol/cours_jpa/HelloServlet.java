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

        UsersEntity user = em.find(UsersEntity.class, "Tzoreol");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + user.getLogin() + " </h1>");
        out.println("<h2>" + user.getRole().getName() + " </h2>");
        out.println("<h2>" + user.getPassword().getPassword() + " </h2>");
        out.println("<h3>" + user.getMessages().size() + " messages</h3>");
        out.println("<ul>");
        for(MesssageEntity message : user.getMessages()) {
            out.println("<li>" + message.getMessage() + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}