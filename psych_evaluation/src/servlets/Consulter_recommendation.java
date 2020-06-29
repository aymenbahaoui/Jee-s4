package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Recommendation;
import dao.DaoFactory;
import dao.RecommendationDao;

/**
 * Servlet implementation class Consulter_recommendation
 */
@WebServlet("/Consulter_recommendation")
public class Consulter_recommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendationDao recommendationDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.recommendationDao = daoFactory.getRecommendationDao();
    }
  
    
    public Consulter_recommendation() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("recommendation", recommendationDao.findByAnswers(Integer.parseInt(request.getParameter("id_answers"))));
        this.getServletContext().getRequestDispatcher("/WEB-INF/consulter_recommendation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
