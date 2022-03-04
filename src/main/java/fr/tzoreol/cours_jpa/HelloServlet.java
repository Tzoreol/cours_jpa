package fr.tzoreol.cours_jpa;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

        String jdbcUrl = "jdbc:mysql://localhost/cours";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "Password0!");
            message = connection.isClosed() ? "Closed" : "Open";
            connection.close();
        } catch (SQLException e) {
            message = "Error";
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}