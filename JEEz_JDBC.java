package AppClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import AppClasses.Play;

public class JEEz_JDBC {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mydb"; //seulement le pc de Louis a la BDD pour le moment
    private static String user = "root"; //identifiant user bdd
    private static String pwd = "1234"; //mdp user bdd
    private static Connection connexion;
    private static Statement statement;

    /*
    Fonction de connexion à la base de donnée
     */
    public void Connection(){
        try {
            Class.forName(this.driver);
        }
        catch (ClassNotFoundException e) {
            e.getMessage();
        }
        try {
            this.connexion = DriverManager.getConnection(this.url, this.user, this.pwd);
            this.statement=this.connexion.createStatement();
        } catch ( SQLException e ) {
            e.getMessage();
        }
    }

    /*
    Fonctionde déconnection de la base de donnée
     */
    public void Deconnection(){
        try {
            this.connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    Fonction d'éxecution de la requête
     */

    public Resulset Query(String query){

            ResultSet rset=null;
            try {
                rset = this.statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rset;
    }

    public void update(String query) {
        try {
            PreparedStatement prepare = this.connexion.prepareStatement(query);
            prepare.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}