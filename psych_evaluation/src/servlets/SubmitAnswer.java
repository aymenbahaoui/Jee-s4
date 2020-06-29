package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Answers;
import beans.Recommendation;

import dao.DaoFactory;
import dao.RecommendationDao;

import daoImpl.AnswerDaoImpl;
import daoImpl.AnswersDaoImpl;
import daoImpl.RecommendationDaoImpl;

/**
 * Servlet implementation class SubmitAnswer
 */
@WebServlet("/SubmitAnswer")
public class SubmitAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendationDao r;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.r= daoFactory.getRecommendationDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
		HttpSession session = request.getSession(false);
		int user_id = (int) session.getAttribute("id");
		AnswersDaoImpl a = new AnswersDaoImpl();
		AnswerDaoImpl an = new AnswerDaoImpl();
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
		int id=(int) a.addAnswers( (String)session.getAttribute("questionnaire"), date, user_id);
		System.out.print(id);
		// getting the key
		
        
			
        Enumeration<String> parameterNames = request.getParameterNames();
 
        while (parameterNames.hasMoreElements()) {
 
            String id_question = parameterNames.nextElement();
            int question = Integer.valueOf(id_question);
            out.write(id_question);
            
            out.write("//n");
 
            String  val =  request.getParameter(id_question);
            int value;
            if(val.equals( "true")) {value=1;}
            else {value=0;}
            
                out.write("t" + value);
                out.write("n");
            an.addAnswer(id, question, value);
 
        }
      

        int similarAnswerId =a.FindSameAnswer(id);
        if(similarAnswerId != 0) {
        	Recommendation rec = r.findByAnswers(similarAnswerId);
        	Recommendation rec2 = r.findByAnswers(similarAnswerId);
        	rec2.setContent(rec.getContent());
        	rec2.setId_answers(id);
        	r.ajouter(rec2);

        }
		this.getServletContext().getRequestDispatcher("/SignIn?login="+session.getAttribute("login")+"&password="+session.getAttribute("password")).forward(request, response);
		out.close();


        
       
 
    }
		
	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
