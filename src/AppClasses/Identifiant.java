package AppClasses;

import java.util.ArrayList;

public class Identifiant {

    private int idIdentifiant;
    private String login;
    private String password;
    private int admin;
    private Gestion_JEEz_JDBC gestion = new Gestion_JEEz_JDBC();

    public int getIdIdentifiant() {
        return idIdentifiant;
    }

    public void setIdIdentifiant(int idIdentifiant) {
        this.idIdentifiant = idIdentifiant;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void connexion(String login, String password){
    	ArrayList<Integer> idRole = gestion.connexion(login,password);
    	this.idIdentifiant = idRole[0];
    	this.admin = idRole[1];
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}