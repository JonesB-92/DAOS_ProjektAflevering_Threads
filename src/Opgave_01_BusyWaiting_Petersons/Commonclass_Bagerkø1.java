package Opgave_01_BusyWaiting_Petersons;

public class Commonclass_Bagerkø1 {
    private volatile int sidstUdleveret = 0;
    private volatile int sidstEkspederet = 0;

    //En common-klasse(r), der indeholder de nødvendige tællere (det er tanken, at du laver to
    //tællere – en tæller, der svarer til det sidste nummer, nummermaskinen har udleveret og et
    //nummer svarende til det sidste nummer, bagerekspedienten har råbt op).

    private boolean[] flag = {false, false};
    private volatile int turn;

    public int udleverNummer() {
        return ++sidstUdleveret;
    }

    public int ekspederNummer() {
        return ++sidstEkspederet;
    }

    public int getSidstUdleveret() {
        return sidstUdleveret;
    }

    public int getSidstEkspederet() {
        return sidstEkspederet;
    }

    public boolean getFlag(int id) {
        return flag[id];
    }

    public void setFlag(boolean flag, int id) {
        this.flag[id] = flag;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getTurn() {
        return turn;
    }
}



