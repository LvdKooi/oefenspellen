package nl.kooi.domain.oefening;

public class OefeningFactory {

    public static Oefening getOefening(int oefeningkeuze, int hoogsteGetal, int tafel) {

        switch (oefeningkeuze) {
            case 1:
                return new DeelOefening(hoogsteGetal);
            case 2:
                return new TafelOefening(tafel, hoogsteGetal);
            case 3:
                return new OptelOefening(hoogsteGetal);
            case 4:
                return new AftrekOefening(hoogsteGetal);
            case 5:
                return new VermenigvuldigOefening(hoogsteGetal);
            default:
                throw new UnsupportedOperationException("Niet toegestane oefeningkeuze.");
        }
    }
}
