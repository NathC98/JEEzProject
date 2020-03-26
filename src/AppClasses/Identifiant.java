package AppClasses;

public class Identifiant {

    private int idIdentifiant;
    private String login;
    private String password;
    private int admin;

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
}
