package Opgave_03_Synchronized;

import java.util.Random;

import static java.lang.Thread.sleep;

public class ThreadIndgang implements Runnable {
    //En tråd-klasse, der simulerer ankomsten til bagerforretningen. Tråden skal med et vist
    //tidsinterval trække et nummer. Der skal laves to instanser af denne klasse.
    private int thisId;
    private int antalNumre;
    private int maxMillis;
    // Link
    private Commonclass_Bagerkø3 queue;

    public ThreadIndgang(Commonclass_Bagerkø3 queue, int id, int numre, int maxMillis) {
        this.queue = queue;
        this.thisId = id;
        antalNumre = numre;
        this.maxMillis = maxMillis;
    }


    //I testsituationen er det lettest at lade ankomsttråde lave f.eks 10 numre hver og lade bagerekspedient
    //klare 20 kunder. Senere kan tallene sættes op
    @Override
    public void run() {
        while (queue.getSidstUdleveret() < antalNumre - 1) {
            waitRandTime();

            int nummer = queue.udleverNummer();
            System.out.println("Indgang " + thisId + " udleverer nummer " + nummer);

        }
    }

    public void waitRandTime() {
        Random random = new Random();
        try {
            sleep(random.nextInt(maxMillis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

