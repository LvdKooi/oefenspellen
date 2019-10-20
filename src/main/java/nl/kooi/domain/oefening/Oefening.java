package nl.kooi.domain.oefening;

public abstract class Oefening {
    protected int antwoord;
    protected int hoogsteGetal;

    public abstract void bepaalOefeningVariabelen();

    public abstract String toString();

    public int getAntwoord() {
        return antwoord;
    }

}
