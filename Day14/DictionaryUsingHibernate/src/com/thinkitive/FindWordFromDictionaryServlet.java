package com.thinkitive;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Servlet implementation class FindWordFromDictionaryServlet
 */
@WebServlet("/FindWordFromDictionaryServlet")
public class FindWordFromDictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindWordFromDictionaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("txtSearchWord");
		List l=null;
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Dictionary.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Criteria c = session.createCriteria(Dictionary.class);
		c.add(Restrictions.eqOrIsNull("word", word));
		l = c.list();
		
		PrintWriter out = response.getWriter();
		out.println(l.get(0));
		//response.sendRedirect("index.jsp?result="+l.get(0));
		t.commit();
		session.close();
		factory.close();
	}

}
