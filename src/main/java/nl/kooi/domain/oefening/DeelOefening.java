package nl.kooi.domain.oefening;

import java.util.Random;

public class DeelOefening extends Oefening {
    private int noemer;
    private int vorigeNoemer;
    private int deler;
    private Random rand;
    private int vraagTeller;
    private int antwoordEenTeller;
    private double antwoordEenVerhouding;

    public DeelOefening(int hoogsteGetal) {
        this.hoogsteGetal = hoogsteGetal;
        rand = new Random();
    }

    @Override
    public void setVraag() {
        ++vraagTeller;
        antwoordEenVerhouding = (double) antwoordEenTeller / (double) vraagTeller;

        do {
            noemer = rand.nextInt(hoogsteGetal) + 1;
            setAntwoord();
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
    public void printVraag() {
        System.out.println("Hoeveel is " + noemer + " / " + deler + "?");
    }

    @Override
    public void setAntwoord() {
        antwoord = rand.nextInt(99999) + 1;
    }

}