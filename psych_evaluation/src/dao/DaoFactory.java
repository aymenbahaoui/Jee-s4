package dao;
import daoImpl.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/jee?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
        
    }

    // Récupération du Dao
    public QuestionnaireDao getQuestionnaireDao() {
        return new QuestionnaireDaoImpl(this);
    }
    public AnswersDao getAnswersDao() {
        return new AnswersDaoImpl(this);
    }
    public RecommendationDao getRecommendationDao() {
        return new RecommendationDaoImpl(this);
    }
}
