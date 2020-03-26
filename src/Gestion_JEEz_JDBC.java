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

	public int numnberPlay(int idPlayer){
		int n =0;

		try {
			String query = "SELECT COUNT(*) FROM Play where idPlayer="+idPlayer; // On selectionne les parties en cour
			ResultSet rset=con.execute(query);
			n=rset.getInt(1);
			}

		} catch ( SQLException e ) {
		}

		return n;
	}





	public ArrayList<Play> ListPlay(){
		ArrayList<Play> listPlay = new  ArrayList<Play>();

		try {
			String query = "SELECT * FROM Play where end=null"; // On selectionne les parties en cour
			ResultSet rset=con.execute(query);
			while ( resultat.next() ) {
				Play p = new Play();

				p.idPlay=rest.getInt("idPlay");
				g.start=rset.getString("start");
				g.end=rset.getString("end");
				g.idGame=rset.getString("idGame");
				g.idPlayer=rset.getString("idPlayer")
				listPlay.add(g);
			}

		} catch ( SQLException e ) {
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
			ResultSet rset=con.execute(query);
			while ( resultat.next() ) {
				Game g = new Game();

				g.idGame=rest.getInt("idGame");
				g.name=rset.getString("name");
				g.numberPlayerGame=rset.getInt("numPlayerInGame");
				g.playable=rset.getInt("playable");

				gameplayable.add(g);
			}

		} catch ( SQLException e ) {
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
			ResultSet rset=con.execute(query);
			if(rset.next()) {
				Player p = new Player();
				p.idPlayer=rset.getInt("idPlayer");
				p.date=set.getString("birthDate");
				p.email=rset.getString("email");
				p.dateinscription=rset.getString("InscriptionDate");
				p.idIdentifiant=rset.getInt("Identifiant_idIdentifiant");
				p.ban=rset.getInt("ban");
				listPlayer.add(p);
			}
			try{
				rest.close;
				this.JEEz_JDBC.Deconnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPlayer;
	}

}