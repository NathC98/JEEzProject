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

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/mydb" //seulement le pc de Louis a la BDD pour le moment
    private String user = "root"; //identifiant user bdd
    private String pwd = "1234"; //mdp user bdd

    private Connection connexion;

    /*
    fonction connexion

    deconnexion

    requete
     */
    /*
    RENVOI LES JEUX DISPONIBLES AUX JOUEURS
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
        } catch ( SQLException e ) {
            e.getMessage());
        }
    }

    public ArrayList<String> playableGame(HttpServletRequest request) {
        /*
            on remplit les informations pour l'url et l'utilisateur de la BDD
        On initialise ce qui va nous servir pour communiquer avec la BDD
         */

        Statement stat = null;
        ResultSet resultat=null;

        /*  Chargement du driver pour la BDD */
        try {
            stat = this.connexion.createStatement();
            resultat = stat.executeQuery("SELECT name FROM Game where playable=true"); // On selectionne le nom des jeux qui sont disponibles sur le site
            
            /* Exécution d'une requête de lecture */
            while ( resultat.next() ) {
            	gameplayable.add(resultat.getString("nom"));
            }
            /*
            On ferme ce qui nous a servit
             */
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
    public ArrayList<Play> currentPlay(HttpServletRequest request) {

        try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            Statement stat = connexion.createStatement();
            ResultSet resultat = stat.executeQuery("SELECT * FROM Play where endDate = null");
            /* Exécution d'une requête de lecture */
            while ( resultat.next() ) {
                Play partie = new Play();
               partie.idPlay=resultat.getInt("idPlay");;
               partie.start=resultat.getInt("start");;
               partie.end=null;
               partie.idgame=resultat.getInt("idGame");;
               partie.idPlayer=resultat.getInt("idPlayer");
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
                partie.idPlay=resultat.getInt("idPlay");;
                partie.start=resultat.getInt("start");;
                partie.end=null;
                partie.idgame=resultat.getInt("idGame");;
                partie.idPlayer=resultat.getInt("idPlayer");
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