package AppClasses;

public class Game {

    private int idGame;
    private String name;
    private int numberPlayerGame;
    private boolean playable;

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;

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
