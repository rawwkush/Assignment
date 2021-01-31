package com.thinkitive;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class counterServlet
 */
@WebServlet("/counterServlet")
public class counterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public counterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			HttpSession session = null;
			session = request.getSession(false);
			out.println("Post method");
			if(session!=null) {
				String c = (String) session.getAttribute("count");
				System.out.println(session.getAttribute("count"));
			}else {
				session = request.getSession();
				session.setAttribute("count", 1);
				RequestDispatcher rd= request.getRequestDispatcher("visitCounter.jsp");
				request.setAttribute("count", String.valueOf("1"));
				rd.forward(request, response);
				System.out.println("Session Created");
			}
		}
		catch(Exception e) {
			out.print("Error");
		}
	}

}
