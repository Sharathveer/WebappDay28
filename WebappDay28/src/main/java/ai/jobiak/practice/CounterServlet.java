package ai.jobiak.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/counterServlet")
public class CounterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		int counter=1;
		if(session.isNew()){
			session.setAttribute("visits",counter+"");
      }else{
		
        	  String counterStr=(String)session.getAttribute("visits");
					counter=Integer.parseInt(counterStr);
					counter++;
					session.setAttribute("visits", counter+"");
					}
		response.setContentType("Text/html");
		out.println("<h3>you visited"+counter+"</h3>");
		out.println("<h3>session ID"+session.getId()+"</h3>");
		out.println("<h3>SessionMaxInterval"+session.getMaxInactiveInterval()+"</h3");
		out.println("<h3><a href='signout'>signout</a>");
		
		
	}

}
