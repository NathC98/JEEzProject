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

    public void inscription(String login, String password){

        String birthdate = this.date;
        String mail = this.email;
        String inscriptionDate = this.dateinscription;

        this.database.Connection();
        ResultSet rset=null;
        try{
            String query = "INSERT INTO Identifiant VALUES (default,"+login+","+password+",0"); // On selectionne les parties en cour
            database.update(query);

            String query2 = "SELECT * FROM Identifiant where login="+login+; // On selectionne les parties en cour
            rset=database.Query(query2);
            int id = rset.getInt(1);

            String query3 = "INSERT INTO Player VALUES (default,"+birthdate+","+mail+","+id+","+inscriptionDate+",0"); // On selectionne les parties en cour
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
}
