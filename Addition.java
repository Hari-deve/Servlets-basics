package operator;

import java.awt.dnd.DragGestureEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Addition extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		add(req, resp);

	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		add(req, resp);
	}
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int value1=Integer.parseInt(req.getParameter("num1"));
		int value2=Integer.parseInt(req.getParameter("num2"));
		
		int result=value1+value2;
		
	/*	PrintWriter out=resp.getWriter();
		out.println("The result is :"+result);*/
		
		
		
		/*
		 Requestor Dispatcher Method to call a squaring Servlet
		 
		req.setAttribute("result", result);
		
		RequestDispatcher directing=req.getRequestDispatcher("Sq");
		directing.forward(req, resp);
		*/
		
		
		/*---> URL Rewriting
		resp.sendRedirect("Sq?resultFromAdd="+result);*/
		
		
		/*
		HTTP Session
		
		HttpSession session=req.getSession();
		session.setAttribute("resultFromAddd", result);
		resp.sendRedirect("Sq");*/
		
		
		Cookie cookie=new Cookie("resultFromAdd", result+"");
		resp.addCookie(cookie);
		resp.sendRedirect("Sq");
		
	}

}
