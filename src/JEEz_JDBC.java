package com.sdzee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import AppClasses.Play;

public class JEEz_JDBC {

    private ArrayList<String> gameplayable = new ArrayList<String>();



    /*
    RENVOI LES JEUX DISPONIBLES AUX JOUEURS
     */
    public ArrayList<String> playableGame(HttpServletRequest request) {

        /*  Chargement du driver pour la BDD */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
                     e.getMessage();
        }
        /*
            on remplit les informations pour l'url et l'utilisateur de la BDD
         */
        String url = "jdbc:mysql://localhost:3306/mydb";  //seulement le pc de Louis a la BDD pour le moment
        String utilisateur = "root"; //identifiant user bdd
        String motDePasse = "1234"; //mdp user bdd
        /*
        On initialise ce qui va nous servir pour communiquer avec la BDD
         */
        try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            
            Statement stat = connexion.createStatement();
            
            ResultSet resultat = stat.executeQuery("SELECT playable_Game FROM ..");//TODO query à compléter en SQL
            
            /* Exécution d'une requête de lecture */
            while ( resultat.next() ) {
            	gameplayable.add(resultat.getString("nom"));
            }
            
            resultat.close();
            
            stat.close();
            
            connexion.close();
            
        } catch ( SQLException e ) {
        	gameplayable.add( "Erreur lors de la connexion : <br/>"+ e.getMessage());
        }
        return gameplayable;
    }
/*
RENVOI LA LISTE DES JOUEURS QUI

 */
    private ArrayList<Play> playcurrent = new ArrayList<Play>();
    
    public ArrayList<Play> currentPlay(HttpServletRequest request) {
        /*  Chargement du driver pour la BDD */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.getMessage();
        }
        /*
         * on remplit les informations pour l'url et l'utilisateur de la BDD
         */
        String url = "jdbc:mysql://localhost:3306/mydb";  //seulement le pc de Louis a la BDD pour le moment
        String utilisateur = "root"; //identifiant user bdd
        String motDePasse = "1234"; //mdp user bdd
        /*
         * On initialise ce qui va nous servir pour communiquer avec la BDD
         */
        try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            Statement stat = connexion.createStatement();
            ResultSet resultat = stat.executeQuery("SELECT * FROM Play where endDate = null");
            /* Exécution d'une requête de lecture */
            while ( resultat.next() ) {
                Play partie = new Play();
                partie.idgame=resultat.getInt("id");
                partie.start=resultat.getDate(2);
                playcurrent.add(partie);
            }
            resultat.close();
            stat.close();
            connexion.close();
        } catch ( SQLException e ) {
        	e.getMessage() ;//FIXME problème de type si ajout dans playcurrent
        }
        return playcurrent;
    }




/*
    public List<String> executerTests(HttpServletRequest request ) {

        /* Chargement du driver JDBC pour MySQL */
        /*try {
            messages.add( "Chargement du driver..." );
            Class.forName( "com.mysql.jdbc.Driver" );
            messages.add( "Driver chargé !" );
        } catch ( ClassNotFoundException e ) {
            messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                    + e.getMessage() );
        }
        /* Connexion à la base de données */
    /*    String url = "jdbc:mysql://localhost:3306/mydb";  //seulement le pc de Louis a la BDD pour le moment
        String utilisateur = "root"; //identifiant user bdd
        String motDePasse = "1234"; //mdp user bdd

        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

            /* Création de l'objet gérant les requêtes */
        /*    CallableStatement req = connexion.prepareCall({"name_Game"});
            resultat = req.execute();
            resultat = statement.executeQuery( "SELECT * FROM Player" );
            String name
            /* Récupération des données du résultat de la requête de lecture */
           /* while ( resultat.next() ) {
                int idUtilisateur = resultat.getInt( "id" );
                String emailUtilisateur = resultat.getString( "email" );
                String motDePasseUtilisateur = resultat.getString( "mot_de_passe" );
                String nomUtilisateur = resultat.getString( "nom" );
                /* Formatage des données pour affichage dans la JSP finale. */
               /* messages.add( "Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur
                        + ", motdepasse = "
                        + motDePasseUtilisateur + ", nom = " + nomUtilisateur + "." );
            }/*
        */
      /*  } catch ( SQLException e ) {
            messages.add( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );
        } /*finally {
            messages.add( "Fermeture de l'objet ResultSet." );
            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Statement." );
            if ( statement != null ) {
                try {
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Connection." );
            if ( connexion != null ) {
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }*/
/*
        return messages;
    }*/
}