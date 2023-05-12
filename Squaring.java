package operator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Squaring extends HttpServlet {
	public void square(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int value1=Integer.parseInt(req.getParameter("num1"));
		int value2=Integer.parseInt(req.getParameter("num2"));
		int result=1;
		
		for (int i =1; i <=value2; i++) {
			result*=value1;
		}
		
		PrintWriter out=resp.getWriter();
		out.println("The result is :"+result);
	}
	
	public void squareTheOutputOfAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//RequestDispatcher Method
		
		
		
		int resultFromAdd=(int) req.getAttribute("result");
		int squareResult=resultFromAdd*resultFromAdd;
		
		PrintWriter out=resp.getWriter();
		out.println("Result from Add: "+resultFromAdd);
		out.println("Result from Square: "+squareResult);
	}
	
	public void squareTheOutputOfAdd2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		//URL Rewriting
		
		int addResult=Integer.parseInt(req.getParameter("resultFromAdd"));
		int squareResult=addResult*addResult;
		PrintWriter out=resp.getWriter();
		out.println("Result from Add: "+addResult);
		out.println("Result from Square: "+squareResult);
		
		
	}

	public void squareTheOutputOfAdd3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//HTTP Session
		
		HttpSession session=req.getSession();
		
		int resultFromAdd=(int) session.getAttribute("resultFromAddd");
		int resultFromSquare=resultFromAdd*resultFromAdd;
		
		PrintWriter out=resp.getWriter();
		out.println("Result from Add: "+resultFromAdd);
		out.println("Result from Square: "+resultFromSquare);
	}
	
	public void squareTheOutputOfAdd4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//Http Cookie
		
		int resultFromAdd=0;
		Cookie[] cookies=req.getCookies();
		
		for (Cookie c : cookies) {
			if (c.getName().equals("resultFromAdd")) {
				resultFromAdd=Integer.parseInt(c.getValue());
			}
		}
		
		int resultFromSquare=resultFromAdd*resultFromAdd;
		
		PrintWriter out=resp.getWriter();
		out.println("Result from Add: "+resultFromAdd);
		out.println("Result from Square: "+resultFromSquare);
		
	}
	
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//square(req, resp);  --> Normal Method
		
		//squareTheOutputOfAdd(req, resp); ---> Request Dispatcher method
		
		//squareTheOutputOfAdd2(req, resp); --> URL Rewriting(sendReDirectng)
		
		//squareTheOutputOfAdd3(req, resp); --> HTTP Session
		
		squareTheOutputOfAdd4(req, resp); //-->HTTP Cookie
	}
}
