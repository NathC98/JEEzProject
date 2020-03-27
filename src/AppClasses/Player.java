package AppClasses;



public class Player {
    private int idPlayer;
    private String date;
    private String email;
    private String dateinscription;
    private int idIdentifiant;
    private boolean ban;

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(String dateinscription) {
        this.dateinscription = dateinscription;
    }

    public int getIdIdentifiant() {
        return idIdentifiant;
    }

    public void setIdIdentifiant(int idIdentifiant) {
        this.idIdentifiant = idIdentifiant;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

}
