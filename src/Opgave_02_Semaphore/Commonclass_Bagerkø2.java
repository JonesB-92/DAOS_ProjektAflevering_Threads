package Opgave_02_Semaphore;

import static java.lang.Thread.sleep;

public class Commonclass_Bagerkø2 {
    private volatile int sidstUdleveret = 0;
    private volatile int sidstEkspederet = 0;

    //En common-klasse(r), der indeholder de nødvendige tællere (det er tanken, at du laver to
    //tællere – en tæller, der svarer til det sidste nummer, nummermaskinen har udleveret og et
    //nummer svarende til det sidste nummer, bagerekspedienten har råbt op).

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

    public int getQueueSize() {
        return sidstUdleveret - sidstEkspederet;
    }

}



