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

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public Gestion_JEEz_JDBC getGestion() {
        return gestion;
    }

    public void setGestion(Gestion_JEEz_JDBC gestion) {
        this.gestion = gestion;
    }

    public void connexion(String login, String password){
    	ArrayList<Integer> idRole = gestion.Connect(login,password);
    	this.idIdentifiant = idRole.get(0);
    	this.admin = idRole.get(1);
    }
    
}