package AppClasses;
import package com.sdzee.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Gestion_JEEz_JDBC{

	private JEEz_JDBC database = new JEEz_JDBC();
	
	public Gestion_JEEz_JDBC(){
		this.JEEz_JDBC.Connection();
	}

	public Player ConnectionPlayer(String login, String password){
			Player p = new Player();
			int identifiant = 0;

			try {

				String query="SELECT * FROM Identifiant WHERE (login= "+login+" AND password= "+password;
				ResultSet rset=Query(query);

				if(rset.next()) {
					identifiant = rset.getInt("idIdentifiant");

					query="SELECT * FROM Player WHERE Identifiant_idIdentifiant="+identifiant;
					ResultSet rset2=Query(query);

					if(rset2.next()){

						Player p = new Player();
						p.idPlayer=rset2.getInt("idPlayer");
						p.date=rset2.getString("birthDate");
						p.email=rset2.getString("email");
						p.dateinscription=rset2.getString("InscriptionDate");
						p.idIdentifiant=rset2.getInt("Identifiant_idIdentifiant");
						p.ban=rset2.getInt("ban");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return person;
		}




	public String PlayTime(int idPlay){
		try {
			String query = "SELECT start FROM Play WHERE idPlay=" + idPlay; // On selectionne les parties en cour
			ResultSet rset1 = update(query);

			String query2 = "SELECT end FROM Play WHERE idPlay=" + idPlay; // On selectionne les parties en cour
			ResultSet rset2 = update(query2);

			String start = rset1.getString(1);
			String end = rset2.getString(2);

			Date dateStart = formatter.parse(start);
			Date dateEnd = formatter.parse(end);

			long resInDays = ChronoUnit.DAYS.between(dateStart,dateEnd);
			String resString = toString(resInDays);
			return resString;

			try{
				rset1.close();
				rset2.close();
				this.JEEz_JDBC.Deconnection();
			}

		}

	}



	public void banPlayer(int idPlayer) {
		try {
			String query = "UPDATE Player SET ban="+1+"WHERE idPlayer="+idPlayer; // On selectionne les parties en cour
			ResultSet rset=update(query);
			try{
				rset.close();
				this.JEEz_JDBC.Deconnection();
			}

		} catch ( SQLException e ) {
		}
	}

	/*
		PROCEDURE EndGame
		PARAMETRE identifiant du joueur, date de fin de partie
	 */

	public void EndGame(int idPlay, String end) {

		try {
			String query = "UPDATE Play SET end="+end+"WHERE idPlay="+idPlay; // On informe la BDD de la date de fin pouyr la partie d'identifiant idPlay passé en paramètre
			ResultSet rset=update(query);
			try{
				rset.close();
				this.JEEz_JDBC.Deconnection();
			}
		} catch ( SQLException e ) {
		}
	}

	/*
	FONCTION : NumberPlay
	PARAMETRE : identifiant du joueur
	RENVOI : le nombre total de parties jouées par le joueur
	 */

	public int NumberPlay(int idPlayer){
		int n =0;

		try {
			String query = "SELECT COUNT(*) FROM Play where idPlayer="+idPlayer; // On selectionne les parties en cour
			ResultSet rset=Query(query);
			n=rset.getInt(1);
			try{
				rset.close();
				this.JEEz_JDBC.Deconnection();
			}
		}
		catch ( SQLException e ) {
		}

		return n;
	}


	/*
		FONCTION 	ListPlay
		PARAMETRE : aucun
		RENVOI : ArrayList de Play contenant toutes les parties en cour
	 */

	public ArrayList<Play> ListPlay(){
		ArrayList<Play> listPlay = new  ArrayList<Play>();

		try {
			String query = "SELECT * FROM Play where end=null"; // On selectionne les parties en cour
			ResultSet rset=Query(query);
			while ( resultat.next() ) {
				Play p = new Play();

				p.idPlay = rset.getInt("idPlay");
				p.start = rset.getString("start");
				p.end = rset.getString("end");
				p.idGame = rset.getString("idGame");
				p.idPlayer = rset.getString("idPlayer")
				listPlay.add(p);
			}
			try{
				rset.close();
				this.JEEz_JDBC.Deconnection();
			}
		}
		catch ( SQLException e ) {
			e.printStackTrace();
		}

		return listPlay;

	}

	/*
		FONCTION 	PlayableGame
		PARAMETRE : aucun
		RENVOI : ArrayList de Game contenant les jeux disponibles sur le site
	 */

	public ArrayList<Game> PlayableGame() {

		ArrayList<Game> gameplayable = new ArrayList<Game>();
		try {
			String query = "SELECT * FROM Game where playable=true"; // On selectionne le nom des jeux qui sont disponibles sur le site
			ResultSet rset=Query(query);
			while ( resultat.next() ) {
				Game g = new Game();

				g.idGame=rest.getInt("idGame");
				g.name=rset.getString("name");
				g.numberPlayerGame=rset.getInt("numPlayerInGame");
				g.playable=rset.getInt("playable");

				gameplayable.add(g);
			}
			try{
				rset.close();
				this.JEEz_JDBC.Deconnection();
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return gameplayable;
	}

	/*
		FONCTION 	ListPlayer
		PARAMETRE : aucun
		RENVOI : ArrayList de Player contenant la liste de tous les joueurs
	 */
	public ArrayList<Player> ListPlayer() {
		ArrayList<Player> listPlayer = new ArrayList<Player>();
		try {
			String query="SELECT * FROM Player";
			ResultSet rset=Query(query);
			if(rset.next()) {
				Player p = new Player();
				p.idPlayer=rset.getInt("idPlayer");
				p.date=rset.getString("birthDate");
				p.email=rset.getString("email");
				p.dateinscription=rset.getString("InscriptionDate");
				p.idIdentifiant=rset.getInt("Identifiant_idIdentifiant");
				p.ban=rset.getInt("ban");
				listPlayer.add(p);
			}
			try{
				rset.close();
				this.JEEz_JDBC.Deconnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPlayer;
	}

}