package nl.kooi.domain.oefening;

public class OptelOefening extends Oefening {
    private int getal1;
    private int getal2;

    public OptelOefening(int hoogsteGetal) {
        this.hoogsteGetal = hoogsteGetal;
        bepaalVraagVariabelen();
    }

    @Override
    public void bepaalVraagVariabelen() {
        getal1 = (int) (Math.random() * hoogsteGetal) + 1;
        getal2 = (int) (Math.random() * hoogsteGetal) + 1;
        antwoord = getal1 + getal2;
    }

    @Override
    public String toString() {
        return "Hoeveel is " + getal1 + " + " + getal2 + "?";
    }

}
