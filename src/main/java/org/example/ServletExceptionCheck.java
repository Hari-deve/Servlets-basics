package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletException")
public class ServletExceptionCheck extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        int dividend=Integer.parseInt(req.getParameter("number1"));
        int divisor=Integer.parseInt(req.getParameter("number2"));

        PrintWriter out=resp.getWriter();

//        try{
            double result=dividend/divisor;
            out.println("The result is : "+result );

//        }catch (ArithmeticException e){
//            resp.sendRedirect("Error");
//        }
    }
}
