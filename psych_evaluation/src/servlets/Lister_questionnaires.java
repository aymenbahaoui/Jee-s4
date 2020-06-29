package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Question;
import beans.Questionnaire;
import dao.DaoFactory;
import dao.QuestionnaireDao;

/**
 * Servlet implementation class Lister_questionnaires
 */
@WebServlet("/Lister_questionnaires")
public class Lister_questionnaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionnaireDao questionnaireDao;

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.questionnaireDao = daoFactory.getQuestionnaireDao();
	}

    public Lister_questionnaires() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Questionnaire> questionnaires = null ; 
        questionnaires  = questionnaireDao.lister();
        request.setAttribute("questionnaires",questionnaires);
        this.getServletContext().getRequestDispatcher("/WEB-INF/lister_questionnaires.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delete = (String) request.getParameter("delete");
		if(delete != null) {
			questionnaireDao.delete(delete);
		}
		doGet(request,response);
	}

}
