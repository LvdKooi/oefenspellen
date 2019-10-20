package nl.kooi.domain.oefening;

public class VermenigvuldigOefening extends Oefening {
    private int getal1;
    private int getal2;

    public VermenigvuldigOefening(int hoogsteGetal) {
        this.hoogsteGetal = hoogsteGetal;
    }

    @Override
    public void setVraag() {
        getal1 = (int) (Math.random() * hoogsteGetal) + 1;
        getal2 = (int) (Math.random() * hoogsteGetal) + 1;
        setAntwoord();
    }

    public void setAntwoord() {
        antwoord = getal1 * getal2;
    }

    @Override
    public void printVraag() {
        System.out.println("Hoeveel is " + getal1 + " * " + getal2 + "?");
    }

}
