

/*
 * 
 * 
 *visitor Counter 
 * 
 * 
 * 
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello") //url mapping to servlet
public class VisitorCounter extends HttpServlet {
	private static final long serialVersionUID = 1L; //used for serilization.. so not  for us for  now
	
	public static long counter=0;

    public VisitorCounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VisitorCounter.counter++;
		response.getWriter().append("Get Visitor number"+ VisitorCounter.counter);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VisitorCounter.counter++;
		response.getWriter().append("Post Visitor number"+ VisitorCounter.counter);
	
		//doGet(request, response);
	}

}
