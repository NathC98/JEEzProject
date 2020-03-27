package AppClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Gestion_JEEz_JDBC{

	private JEEz_JDBC database = new JEEz_JDBC();

	public Gestion_JEEz_JDBC(){
	}

/*
					if(admin==0) {
						query2 = "SELECT * FROM Player WHERE Identifiant_idIdentifiant=" + identifiant;
						ResultSet rset2 = Query(query2);

						if (rset2.next()) {

							Player p = new Player();
							p.setIdPlayer(rset2.getInt("idPlayer"));
							p.setDate(rset2.getString("birthDate"));
							p.setEmail(rset2.getString("email"));
							p.setDateinscription(rset2.getString("InscriptionDate"));
							p.setIdIdentifiant(rset2.getInt("Identifiant_idIdentifiant"));
							p.setBan(rset2.getInt("ban"));
						}
						query3 = "SELECT * FROM Administrator WHERE Identifiant_idIdentifiant=" + identifiant;
						ResultSet rset2 = Query(query3);
						if (rset3.next()) {
							Administrator
						}
					}
				}
 */

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

	public ArrayList<Integer> Connect(String login, String password) {
		this.database.Connection();
		ArrayList<Integer> Info = new ArrayList<Integer>();
		int identifiant = 0;
		int admin = 0;
		ResultSet rset=null;

		try {
			String query = "SELECT * FROM Identifiant WHERE (login= " + login + " AND password= " + password;
			rset = database.Query(query);
			if (rset.next()) {
				identifiant = rset.getInt("idIdentifiant");
				admin = rset.getInt("admin");
				Info.add(identifiant);
				Info.add(admin);

			}else{
				Info=null;
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
/*
			Date dateStart = formatter.parse(start);
			Date dateEnd = formatter.parse(end);

			long resInDays = ChronoUnit.DAYS.between(dateStart,dateEnd);
			String resString = toString(resInDays);*/



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
		String query = "UPDATE Play SET end="+end+"WHERE idPlay="+idPlay; // On informe la BDD de la date de fin pouyr la partie d'identifiant idPlay passé en paramètre
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
				g.setNumberPlayerGame(rset.getInt("numPlayerInGame"));
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

}