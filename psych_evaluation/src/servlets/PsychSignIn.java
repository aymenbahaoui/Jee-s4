package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PsychSignIn
 */
@WebServlet("/PsychSignIn")
public class PsychSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PsychSignIn() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//put psych servlet		
				String url =  "/lister_answers";
				String login = request.getParameter("login");
				String pass = request.getParameter("password");
				if ( login.equals("psych") & pass.equals("psych")) {
					getServletContext().getRequestDispatcher(url).forward(request, response);
				}
				else {
					getServletContext().getRequestDispatcher("/PsychSignIn.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
