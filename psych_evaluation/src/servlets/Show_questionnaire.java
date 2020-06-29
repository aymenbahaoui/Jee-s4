package servlets;

import beans.* ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import java.util.*;
@WebServlet("/Show_questionnaire")
public class Show_questionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	  private QuestionnaireDao questionnaireDao;

	    public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.questionnaireDao = daoFactory.getQuestionnaireDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setAttribute("questionnaire", questionnaireDao.find(request.getParameter("title")));
	      
	        this.getServletContext().getRequestDispatcher("/WEB-INF/show_questionnaire.jsp").forward(request, response);
	    }

	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        Questionnaire questionnaire = new Questionnaire();
	        List<Question> questions = new ArrayList<Question>(); 
	        questionnaire.setTitle(request.getParameter("title"));
	        Question question = null;
	        int i =1 ;
	        while(request.getParameter("q"+i) != null) {
	        	question = new Question();
	        	question.setContent(request.getParameter("q"+i));
	        	questions.add(question);
	        	i++;
	        }
	        
	        questionnaire.setLength(questions.size());
	        questionnaire.setQuestions(questions);
	        questionnaireDao.ajouter(questionnaire);
	        
	        request.setAttribute("questionnaire", questionnaireDao.find(questionnaire.getTitle()));
	        this.getServletContext().getRequestDispatcher("/WEB-INF/show_questionnaire.jsp").forward(request, response);
	    }
	    
}