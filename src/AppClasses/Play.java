package AppClasses;

<<<<<<< HEAD
public class Play {

    private int idPlay;
    private String start;
    private String end;
    private int idgame;
    private int idPlayer;

    public int getIdPlay() {
        return idPlay;
    }

    public void setIdPlay(int idPlay) {
        this.idPlay = idPlay;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
=======
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
>>>>>>> branch 'master' of https://github.com/NathC98/JEEzProject.git
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
