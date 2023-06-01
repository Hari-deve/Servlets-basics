package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Error")
public class ErrorPage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Integer status = (Integer) req.getAttribute("javax.servlet.error.status_code");

        Throwable exceptionName = (Throwable) req.getAttribute("javax.servlet.error.exception");
        PrintWriter out=resp.getWriter();
        out.println("Error code: "+status+"<br></br>");
        out.println("Exception Occurred: "+exceptionName+"<br></br>");
        out.println("You have entered wrong Inputs Check Again"+"<br></br>");
        out.println("<form action = 'home'>");
        out.println("<input type='submit' value='home'>");
        out.println("</form>");
    }
}
