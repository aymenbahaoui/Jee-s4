package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnswersDao;
import dao.DaoFactory;
import dao.QuestionnaireDao;

/**
 * Servlet implementation class Donner_Recommendation
 */
@WebServlet("/Donner_Recommendation")
public class Donner_Recommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private AnswersDao answersDao;

	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.answersDao = daoFactory.getAnswersDao();
	    }
	
	
	
    public Donner_Recommendation() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("answers", answersDao.find( Integer.parseInt( request.getParameter("id_answers") ) ) );
        this.getServletContext().getRequestDispatcher("/WEB-INF/donner_recommendation.jsp").forward(request, response);
	}

}
