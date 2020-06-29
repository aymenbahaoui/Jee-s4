package servlets;
import dao.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Question;
import beans.Questionnaire;

import java.util.*;
/**
 * Servlet implementation class Ajouter_Questionnair_csv
 */
@WebServlet("/Ajouter_Questionnaire_csv")
public class Ajouter_Questionnaire_csv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240;
	public static final String CHEMIN_FICHIERS = "C:\\Users\\Kisuke\\Desktop\\fichiers\\"; // A changer
	private QuestionnaireDao questionnaireDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.questionnaireDao = daoFactory.getQuestionnaireDao();
    }
    public Ajouter_Questionnaire_csv() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/prepare_qust_csv.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        // On récupère le champ du fichier
	        Part part = request.getPart("fichier");
	            
	        // On vérifie qu'on a bien reçu un fichier
	        String nomFichier = getNomFichier(part);

	        // Si on a bien un fichier
	        if (nomFichier != null && !nomFichier.isEmpty()) {
	            String nomChamp = part.getName();
	            // Corrige un bug du fonctionnement d'Internet Explorer
	             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
	                    .substring(nomFichier.lastIndexOf('\\') + 1);

	            // On écrit définitivement le fichier sur le disque
	            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

	            request.setAttribute(nomChamp, nomFichier);
	        }
	        List<String> questions_content = analyser_fichier(nomFichier,CHEMIN_FICHIERS);
	        if (questions_content.size()>=2) {
		        Questionnaire questionnaire = new Questionnaire();
		        List<Question> questions = new ArrayList<Question>(); 
		        questionnaire.setTitle(questions_content.get(0));
		        Question question = null;
		        int i =1 ;
		        while(i < questions_content.size()) {
		        	question = new Question();
		        	question.setContent(questions_content.get(i));
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
	
	private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
   
    }   
    
    private List<String> analyser_fichier (String nomFichier, String chemin) {
    	 	List<String> questions_content = new ArrayList<String>();
    		File file = new File(chemin+nomFichier);
 
    		String content = null;
    		try {
    			try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
    				scanner.useDelimiter("\n");
    				while(scanner.hasNext()) {
    					content = scanner.nextLine();
    					questions_content.add(content);
    					
    				}
    				
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}

    		
    		return questions_content ; 
    }
    
    
   
}   

	

