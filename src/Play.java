package AppClasses;

import java.sql.Date;

public class Play {

	private int idPlay;
    public Date start;
    private Date end;
    public int idgame;
    private int idPlayer;

    public int getIdPlay() {
        return idPlay;
    }

    public void setIdPlay(int idPlay) {
        this.idPlay = idPlay;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getIdgame() {
        return idgame;
    }

    public void setIdgame(int idgame) {
        this.idgame = idgame;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }
}
