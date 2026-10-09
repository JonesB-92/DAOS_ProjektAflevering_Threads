package Opgave_02_Semaphore;

public class Main {
    //Der skal laves en main til at starte det hele og der skal laves diverse udskrifter, så du
    //undervejs kan følge køens størrelse – du kan vente med disse til du kan se, hvornår det er
    //interessant at lave en udskrift
    public static void main(String[] args) {
        // Opgave 2: Semaforer
        Commonclass_Bagerkø2 bagerkø1 = new Commonclass_Bagerkø2();

        Thread indgangA = new Thread(new ThreadIndgang(bagerkø1, 0, 20, 100));
        Thread IndgangB = new Thread(new ThreadIndgang(bagerkø1, 1, 20, 100));
        Thread ekspedient = new Thread(new ThreadEkspedient(1, 100, 20, bagerkø1));

        indgangA.start();
        IndgangB.start();
        ekspedient.start();

        try {
            indgangA.join();
            IndgangB.join();
            ekspedient.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Opgave 2 færdig. Sidste udleverede nummer: " +
                bagerkø1.getSidstUdleveret() + ", Sidste tilkaldt: " + bagerkø1.getSidstEkspederet());

    }
}
