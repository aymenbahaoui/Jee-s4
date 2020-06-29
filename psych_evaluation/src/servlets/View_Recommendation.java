package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Recommendation;
import dao.DaoFactory;
import dao.QuestionnaireDao;
import dao.RecommendationDao;


@WebServlet("/View_submission")
public class View_Recommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendationDao recommendationDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.recommendationDao = daoFactory.getRecommendationDao();
    }

    
    public View_Recommendation() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Recommendation recommendation = new Recommendation();
        recommendation.setContent(request.getParameter("content"));
        recommendation.setId_answers(Integer.parseInt(request.getParameter("id_answers")));
        
        recommendationDao.ajouter(recommendation);
        request.setAttribute("recommendation", recommendationDao.findByAnswers(recommendation.getId_answers()));
        this.getServletContext().getRequestDispatcher("/WEB-INF/view_recommendation.jsp").forward(request, response);
	}

}
