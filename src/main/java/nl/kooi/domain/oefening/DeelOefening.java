package nl.kooi.domain.oefening;

import java.util.Random;

public class DeelOefening extends Oefening {
    private int noemer;
    private int deler;
    private Random rand;
    private static int vraagTeller;
    private static int antwoordEenTeller;
    private static double antwoordEenVerhouding;
    private static int vorigeNoemer;

    public DeelOefening(int hoogsteGetal) {
        this.hoogsteGetal = hoogsteGetal;
        rand = new Random();
        bepaalVraagVariabelen();
    }

    @Override
    public void bepaalVraagVariabelen() {
        ++vraagTeller;
        antwoordEenVerhouding = (double) antwoordEenTeller / (double) vraagTeller;

        do {
            noemer = rand.nextInt(hoogsteGetal) + 1;
            antwoord = rand.nextInt(99999) + 1;
            deler = noemer * antwoord;
        }
        while (noemer > hoogsteGetal ||
                deler > hoogsteGetal ||
                (antwoord == 1 && antwoordEenVerhouding > 0.1) ||
                vorigeNoemer == noemer);

        vorigeNoemer = noemer;

        antwoordEenTeller = antwoord == 1 ? ++antwoordEenTeller : antwoordEenTeller;

    }

    @Override
    public String toString() {
        return "Hoeveel is " + noemer + " / " + deler + "?";
    }
}