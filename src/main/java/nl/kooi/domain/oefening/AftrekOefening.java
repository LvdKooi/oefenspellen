package nl.kooi.domain.oefening;

public class AftrekOefening extends Oefening {
    private int getal1;
    private int getal2;

    public AftrekOefening(int hoogsteGetal) {
    this.hoogsteGetal = hoogsteGetal;
    }

    @Override
    public void setVraag() {
    getal1 = (int) (Math.random() * hoogsteGetal) + 1;
	do {
        getal2 = (int) (Math.random() * hoogsteGetal) + 1;
    }
	while(getal2 > getal1);

	setAntwoord();
    }

      public void setAntwoord() {
        antwoord = getal1 - getal2;
    }

    @Override
    public void printVraag() {
        System.out.println("Hoeveel is " + getal1 + " - " + getal2 + "?");
    }

}
