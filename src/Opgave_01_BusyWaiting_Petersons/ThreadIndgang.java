package Opgave_01_BusyWaiting_Petersons;

public class ThreadIndgang implements Runnable {
    //En tråd-klasse, der simulerer ankomsten til bagerforretningen. Tråden skal med et vist
    //tidsinterval trække et nummer. Der skal laves to instanser af denne klasse.
    private int thisId;
    private int otherId;
    private int antalKunder;
    private int maxMillis;
    // Link
    private Commonclass_Bagerkø1 queue;

    public ThreadIndgang(Commonclass_Bagerkø1 queue, int id, int maxAntalKunder, int maxMillis) {
        this.queue = queue;
        this.thisId = id;
        antalKunder = maxAntalKunder;
        this.maxMillis = maxMillis;
    }

    //I testsituationen er det lettest at lade ankomsttråde lave f.eks 10 numre hver og lade bagerekspedient
    //klare 20 kunder. Senere kan tallene sættes op
    @Override
    public void run() {
        while (queue.getSidstUdleveret() < antalKunder) {
            otherId = (thisId + 1) % 2;
            queue.setFlag(true, thisId);
            queue.setTurn(otherId);

            while (queue.getFlag(otherId) && queue.getTurn() == otherId); //Busy waiting

            int nummer = queue.udleverNummer();
            System.out.println("Indgang " + thisId + " udleverer nummer " + nummer);
        }
    }
}

