package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Question;
import daoImpl.QuestionDaoImpl;


/**
 * Servlet implementation class TakeQuestionnaire
 */
@WebServlet("/TakeQuestionnaire")
public class TakeQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeQuestionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String title = (String)request.getParameter("title");
		QuestionDaoImpl q = new QuestionDaoImpl();
		List<Question> questions = q.getQuestionsByQuestionnaire(title);
				
		HttpSession session = request.getSession(false);
		session.setAttribute("questionnaire", title);

		request.setAttribute("user", session.getAttribute("login"));

		request.setAttribute("questions", questions);
		request.setAttribute("title", title);

		  getServletContext().getRequestDispatcher("/Questionnaire.jsp").forward(
		  request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
