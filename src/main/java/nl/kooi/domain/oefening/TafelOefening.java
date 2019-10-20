package nl.kooi.domain.oefening;

public class TafelOefening extends Oefening {
    private static int tafel;
    private static int hoogsteGetal;
    private int vraag;

    public TafelOefening(int tafel, int hoogsteGetal) {
        TafelOefening.tafel = tafel;
        TafelOefening.hoogsteGetal = hoogsteGetal;
        bepaalOefeningVariabelen();
    }

    @Override
    public void bepaalOefeningVariabelen() {
        vraag = (int) (Math.random() * hoogsteGetal) + 1;
        antwoord = vraag * tafel;
    }

    @Override
    public String toString() {
        return "Hoeveel is " + vraag + " X " + tafel + "?";
    }

}
