package AppClasses;

public class Game {

    private int idGame;
    private String nom;
    private int numberPlayerGame;
    private boolean playable;

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumberPlayerGame() {
        return numberPlayerGame;
    }

    public void setNumberPlayerGame(int numberPlayerGame) {
        this.numberPlayerGame = numberPlayerGame;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
}
