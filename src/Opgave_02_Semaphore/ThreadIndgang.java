package Opgave_02_Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class ThreadIndgang implements Runnable {
    //En tråd-klasse, der simulerer ankomsten til bagerforretningen. Tråden skal med et vist
    //tidsinterval trække et nummer. Der skal laves to instanser af denne klasse.
    private int thisId;
    private int antalNumre;
    private int maxMillis;
    // Link
    private Commonclass_Bagerkø2 queue;

    static Semaphore semaphore = new Semaphore(1);

    public ThreadIndgang(Commonclass_Bagerkø2 queue, int id, int maxAntalKunder, int maxMillis) {
        this.queue = queue;
        this.thisId = id;
        antalNumre = maxAntalKunder;
        this.maxMillis = maxMillis;
    }


    //I testsituationen er det lettest at lade ankomsttråde lave f.eks 10 numre hver og lade bagerekspedient
    //klare 20 kunder. Senere kan tallene sættes op
    @Override
    public void run() {
        while (queue.getSidstUdleveret() < antalNumre -1 ) {
            waitRandTime();
            //Critical sektion
            try {
                semaphore.acquire();
                int nummer = queue.udleverNummer();
                System.out.println("Indgang " + thisId + " udleverer nummer " + nummer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphore.release();
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

