package nl.kooi.domain.oefening;

public abstract class Oefening {
    protected int antwoord;
    protected int hoogsteGetal;

    public abstract void setVraag();

    public abstract void printVraag();

    public abstract void setAntwoord();

    public int getAntwoord() {
        return antwoord;
    }

}
