package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.UserDaoImpl;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")

public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url =  "/User";
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		UserDaoImpl impl = new UserDaoImpl();
		beans.User user = impl.login(login, pass);
		if ( user == null) {
			//incorrect login
		}
		else {

			session.setAttribute("id", user.getId_employe());
			session.setAttribute("name", user.getName());
			System.out.print(user.getName());
			session.setAttribute("password", pass);
			session.setAttribute("login", login);
			System.out.print(session.getAttribute("name"));
			request.setAttribute("user", user);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
