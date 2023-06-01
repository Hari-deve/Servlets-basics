package org.example;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/error404")
public class Error404 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        Integer status = (Integer) req.getAttribute("javax.servlet.error.status_code");

        String reqURI = (String) req.getAttribute("javax.servlet.error.request_uri");
        out.println("Error code: "+status+"<br></br>");
        out.println("Error URI: "+reqURI+"<br></br>");
        out.println("No such file found"+"<br></br>");
        out.println("<form action = 'home'>");
        out.println("<input type='submit' value='home'>");
        out.println("</form>");

    }
}
