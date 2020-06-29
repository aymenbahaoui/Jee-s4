package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;
import dao.*;

@WebServlet("/Lister_answers")
public class Lister_answers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AnswersDao answersDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.answersDao = daoFactory.getAnswersDao();
    }
    public Lister_answers() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Answers> list_answers = null ; 
        list_answers  = answersDao.lister_nonTraite();
        request.setAttribute("list_answers",list_answers);
        for(Answers answers : list_answers ) {
        	System.out.println(answers.getId_answers());
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/lister_answers.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
