package nl.kooi.domain;

public class TafelOefening extends Oefening {
    private static int tafel;
    private static int hoogsteGetal;
    private int vraag;

    public TafelOefening(int tafel, int hoogsteGetal) {
        this.tafel = tafel;
        this.hoogsteGetal = hoogsteGetal;
    }

    @Override
    public void setVraag() {
        vraag = (int) (Math.random() * hoogsteGetal) + 1;
        setAntwoord();
    }

    public int getVraag() {
        return vraag;
    }

    public void setAntwoord() {
        antwoord = vraag * tafel;

    }

    @Override
    public void printVraag() {
        System.out.println("Hoeveel is " + getVraag() + " X " + tafel + "?");
    }

}
