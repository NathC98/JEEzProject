package AppClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.*;
import java.time.Period;
import java.sql.Date;


public class Gestion_JEEz_JDBC{

	private JEEz_JDBC database = new JEEz_JDBC();

	public Gestion_JEEz_JDBC(){

	}

	/*
                FONCTION infoPlayer
                PARAMETRE login + password
                RENVOI tableau d'entier, où le premier entier contient l'identifiant dans al classe Identifiant de la BDD, le deuxieme 0 ou 1 pour savoir si c'est un admin ou un joueur.
                Si le login/password ne convient pas, renvoi null
             */

	public Player infoPlayer(int idPlayer) {
		this.database.Connection();
		Player p = new Player();
		ResultSet rset=null;
		try {
			String query = "SELECT * FROM Player WHERE idPlayer=" + idPlayer;
			rset = database.Query(query);
			if (rset.next()) {
				p = new Player();
				p.setIdPlayer(rset.getInt("idPlayer"));
				p.setDate(rset.getString("birthDate"));
				p.setEmail(rset.getString("email"));
				p.setDateinscription(rset.getString("InscriptionDate"));
				p.setIdIdentifiant(rset.getInt("Identifiant_idIdentifiant"));
				p.setBan(rset.getBoolean("ban"));
			}
			else{
				p=null;
			}
		}catch ( SQLException e ) {
			e.printStackTrace();
		}
		try{
			rset.close();
			this.database.Deconnection();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}
		return p;
	}

		/*
			FONCTION Connect
			PARAMETRE login + password
			RENVOI tableau d'entier, où le premier entier contient l'identifiant dans al classe Identifiant de la BDD, le deuxieme 0 ou 1 pour savoir si c'est un admin ou un joueur.
			Si le login/password ne convient pas, renvoi null
		 */


/*
	FONCTION Connect
	PARAMETRE  login, password


 */

	public ArrayList<Integer> Connect(String login, String password) {
		this.database.Connection();
		ArrayList<Integer> Info = new ArrayList<Integer>();
		int identifiant = 0;
		int admin = 0;
		ResultSet rset=null;

		try {
			String query = "SELECT * FROM Identifiant WHERE (login='" + login + "' AND password='" + password+"')";
			System.out.println(query);
			rset = database.Query(query);
			if (rset.next()) {
				identifiant = rset.getInt("idIdentifiant");
				admin = rset.getInt("admin");
				Info.add(identifiant);
				Info.add(admin);

			}else{
				Info.add(-1);
				Info.add(-1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			rset.close();
			this.database.Deconnection();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return Info;
	}

	/*
	FONCTION Playtime
	PARAMETRE entier idPlay, identifiant de la partie
	RENVOI

	 */

	public String PlayTime(int idPlay){
		this.database.Connection();
		String resString="oui";
		try {
			String query = "SELECT start FROM Play WHERE idPlay=" + idPlay; // On selectionne les parties en cour
			ResultSet rset1 = database.Query(query);

			String query2 = "SELECT end FROM Play WHERE idPlay=" + idPlay; // On selectionne les parties en cour
			ResultSet rset2 = database.Query(query2);

			String start = rset1.getString(1);
			String end = rset2.getString(2);
			LocalDate dateStart = LocalDate.parse(start);
			LocalDate dateEnd = LocalDate.parse(end);
			Period period = Period.between(dateStart, dateEnd);
			int diff = period.getDays();
			resString = Integer.toString(diff);

			try{
				rset1.close();
				rset2.close();
				this.database.Deconnection();
			}
			catch ( SQLException e ) {
				e.printStackTrace();
			}

		}catch ( SQLException e ) {
			e.printStackTrace();
		}
		return resString ;
	}

	/*
	PROCEDURE banPlayer
	PARAMETRE idPlayer
	banni un joueur du serveur.
	 */

	public void banPlayer(int idPlayer) {
		this.database.Connection();
		String query = "UPDATE Player SET ban="+1+"WHERE idPlayer="+idPlayer; // On selectionne les parties en cour
		database.update(query);
		this.database.Deconnection();

	}

	/*
		PROCEDURE EndGame
		PARAMETRE identifiant du joueur, date de fin de partie
	 */

	public void EndGame(int idPlay, String end) {
		this.database.Connection();
		String query = "UPDATE Play SET end='"+end+"' WHERE idPlay="+idPlay; // On informe la BDD de la date de fin pouyr la partie d'identifiant idPlay passé en paramètre
		database.update(query);
		this.database.Deconnection();
	}

	/*
	FONCTION : NumberPlay
	PARAMETRE : identifiant du joueur
	RENVOI : le nombre total de parties jouées par le joueur
	 */

	public int NumberPlay(int idPlayer){
		this.database.Connection();
		ResultSet rset=null;
		int n =0;

		try {
			String query = "SELECT COUNT(*) FROM Play where idPlayer="+idPlayer; // On selectionne les parties en cour
			rset=database.Query(query);
			n=rset.getInt(1);
		}
		catch ( SQLException e ) {
		}

		try{
			rset.close();
			this.database.Deconnection();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}

		return n;
	}


	/*
		FONCTION 	ListPlay
		PARAMETRE : aucun
		RENVOI : ArrayList de Play contenant toutes les parties en cour
	 */

	public ArrayList<Play> ListPlay(){
		this.database.Connection();
		ArrayList<Play> listPlay = new  ArrayList<Play>();
		ResultSet rset=null;
		try {
			String query = "SELECT * FROM Play where end=null"; // On selectionne les parties en cour
			rset=database.Query(query);
			while ( rset.next() ) {
				Play p = new Play();

				p.setIdPlay(rset.getInt("idPlay"));
				p.setStart(rset.getString("start"));
				p.setEnd (rset.getString("end"));
				p.setIdgame(rset.getInt("idGame"));
				p.setIdPlayer(rset.getInt("idPlayer"));
				listPlay.add(p);
			}
			try{
				rset.close();
				this.database.Deconnection();
			}catch ( SQLException e ) {
				e.printStackTrace();
			}

		}
		catch ( SQLException e ) {
		}

		return listPlay;

	}

	/*
		FONCTION 	PlayableGame
		PARAMETRE : aucun
		RENVOI : ArrayList de Game contenant les jeux disponibles sur le site
	 */

	public ArrayList<Game> PlayableGame() {
		this.database.Connection();
		ResultSet rset=null;
		ArrayList<Game> gameplayable = new ArrayList<Game>();
		try {
			String query = "SELECT * FROM Game where playable=true"; // On selectionne le nom des jeux qui sont disponibles sur le site
			rset=database.Query(query);
			while ( rset.next() ) {
				Game g = new Game();

				g.setIdGame(rset.getInt("idGame"));
				g.setName(rset.getString("name"));
				g.setNumberPlayerGame(rset.getInt("numberPlayerInGame"));
				g.setPlayable(rset.getBoolean("playable"));

				gameplayable.add(g);
			}
			try{
				rset.close();
				this.database.Deconnection();
			}catch ( SQLException e ) {
				e.printStackTrace();
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
		this.database.Connection();
		ResultSet rset=null;
		ArrayList<Player> listPlayer = new ArrayList<Player>();
		try {
			String query="SELECT * FROM Player";
			rset=database.Query(query);
			if(rset.next()) {
				Player p = new Player();
				p.setIdPlayer(rset.getInt("idPlayer"));
				p.setDate(rset.getString("birthDate"));
				p.setEmail(rset.getString("email"));
				p.setDateinscription(rset.getString("InscriptionDate"));
				p.setIdIdentifiant(rset.getInt("Identifiant_idIdentifiant"));
				p.setBan(rset.getBoolean("ban"));
				listPlayer.add(p);
			}
			try{
				rset.close();
				this.database.Deconnection();
			}
			catch ( SQLException e ) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPlayer;
	}

	public void Favorite(int idGame, int idPlayer){
		this.database.Connection();
		String query = "UPDATE Player_has_Game SET favorite=1 WHERE idPlayer="+idPlayer+" AND Game_idGame="+idGame; // On selectionne les parties en cour
		database.update(query);
		this.database.Deconnection();
	}

	public void updatePlayer(int idPlayer, String birthDate, String mail){

		this.database.Connection();
		String query = "UPDATE Player SET birthDate='"+birthDate+"' AND mail='"+mail+"' WHERE idPlayer="+idPlayer; // On selectionne les parties en cour
		database.update(query);
		this.database.Deconnection();
	}


	public void InsertPlayer(String login, String password, String birthdate, String mail, String inscriptionDate){
		this.database.Connection();
		ResultSet rset=null;
		try{
			String query = "INSERT INTO Identifiant VALUES (default,'"+login+"','"+password+"',0"; // On selectionne les parties en cour
			database.update(query);

			String query2 = "SELECT * FROM Identifiant where login='"+login+"'"; // On selectionne les parties en cour
			rset=database.Query(query2);
			int id = rset.getInt(1);

			String query3 = "INSERT INTO Player VALUES (default,'"+birthdate+"','"+mail+"',"+id+",'"+inscriptionDate+"',0"; // On selectionne les parties en cour
			database.update(query);
		}catch ( SQLException e ) {
			e.printStackTrace();
		}
		try{
			rset.close();
			this.database.Deconnection();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	/*
	FONCTION GameFromPlayerHasGame
	PARAMETRE idGame
	Permet de récupérer la liste des joueurs ayant une partie en cours pour un jeu en particulier.
	 */

	public ArrayList<Player_has_Game> GameFromPlayerHasGame(int idGame){
		this.database.Connection();
		ArrayList<Player_has_Game> listPHG = new  ArrayList<Player_has_Game>();
		ResultSet rset=null;
		try {
			String query = "SELECT * FROM Player_has_Game where Game_idGame="+idGame; // On selectionne les parties en cour
			rset=database.Query(query);
			while ( rset.next() ) {
				Player_has_Game phd = new Player_has_Game();
				phd.setIdPlayer(rset.getInt("idPlayer"));
				phd.setIdGame(rset.getInt("Game_idGame"));
				phd.setHighscore(rset.getInt("highscore"));
				phd.setFavorite(rset.getBoolean("favorite"));
				listPHG.add(phd);
			}
			try{
				rset.close();
				this.database.Deconnection();
			}catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
		catch ( SQLException e ) {
		}
		return listPHG;
	}

	public void notPlayable(int idGame){
		this.database.Connection();
		String query = "UPDATE Game SET playable=0 WHERE idGame="+idGame; // On selectionne les parties en cour
		database.update(query);
		this.database.Deconnection();

	}

	public String gameFromPlay(int idPlay){

		this.database.Connection();
		ResultSet rset=null;
		String str = null;

		try {
			String query = "SELECT Game.name FROM Play,Game  where Play.idPlay =" + idPlay + " AND Play.idGame=Game.idGame"; // On selectionne les parties en cour
			rset = database.Query(query);
			str=rset.getString(1);

			rset.close();
			this.database.Deconnection();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}
		return str;
	}

	/*
	renvoi le nom du joueur qui joue à la partie dont l'identifiant est passé en paramètre
	 */

	public String playerFromPlay(int idPlay){
		this.database.Connection();
		ResultSet rset=null;
		String str = null;
		try {
			String query = "SELECT Identifiant.login FROM Play,Player,Identifiant  where Play.idPlay ="+ idPlay +" AND Play.idPlayer=Player.idPlayer AND Identifiant.idIdentifiant=Player.Identifiant_idIdentifiant"; // On selectionne les parties en cour
			rset = database.Query(query);
			str=rset.getString(1);

			rset.close();
			this.database.Deconnection();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}
		return str;
	}

	public void insertGame(String name, boolean playable){
		this.database.Connection();
		String query = "INSERT INTO Game VALUES (default,"+name+",0,"+playable+")"; // On insère un nouveau jeu
		database.update(query);
		this.database.Deconnection();
	}
}