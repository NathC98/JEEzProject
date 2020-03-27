package AppClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JEEz_JDBC {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; //seulement le pc de Louis a la BDD pour le moment
    private String user = "root"; //identifiant user bdd
    private String pwd = "Ellmancccel1a82!"; //mdp user bdd
    private Connection connexion;
    private Statement statement;

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
            e.printStackTrace();
        }
    }

    /*
    Fonctionde déconnection de la base de donnée
     */
    public void Deconnection(){
       try{
           this.connexion.close();
       }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    Fonction d'éxecution de la requête
     */

    public ResultSet Query(String query){

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