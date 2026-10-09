package Opgave_01_BusyWaiting_Petersons;

import java.util.Random;

import static java.lang.Thread.sleep;

public class ThreadEkspedient implements Runnable {
    //• En tråd-klasse, der simulerer ekspedienten. Tråden skal med et vist tidsinterval råbe et nyt
    //nummer op. (det kan den naturligvis kun gøre, hvis der er folk, der venter), Der skal kun
    //være en instans af denne klasse.

    private int id;
    private int maxMillis;
    private int antalKunder;
    // Link
    private Commonclass_Bagerkø1 queue;

    public ThreadEkspedient(int id, int maxMillis, int antalNumre, Commonclass_Bagerkø1 queue) {
        this.id = id;
        this.maxMillis = maxMillis;
        this.antalKunder = antalNumre;
        this.queue = queue;
    }


    //I testsituationen er det lettest at lade ankomsttråde lave f.eks 10 numre hver og lade bagerekspedient
    //klare 20 kunder. Senere kan tallene sættes op
    @Override
    public void run() {
        while (queue.getSidstEkspederet() <= antalKunder) {
            waitRandTime();

            while (queue.getSidstEkspederet() == queue.getSidstUdleveret());

            int nummer = queue.ekspederNummer();
            System.out.println("Eskpedient " + id + " tilkalder nummer " + nummer);

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


