package Opgave_03_Synchronized;

public class Commonclass_Bagerkø3 {
    private volatile int sidstUdleveret = 0;
    private volatile int sidstEkspederet = 0;

    //En common-klasse(r), der indeholder de nødvendige tællere (det er tanken, at du laver to
    //tællere – en tæller, der svarer til det sidste nummer, nummermaskinen har udleveret og et
    //nummer svarende til det sidste nummer, bagerekspedienten har råbt op).

    public synchronized int udleverNummer() {
        return ++sidstUdleveret;
    }

    public synchronized int ekspederNummer() {
        return ++sidstEkspederet;
    }

    public int getSidstUdleveret() {
        return sidstUdleveret;
    }

    public int getSidstEkspederet() {
        return sidstEkspederet;
    }

}



