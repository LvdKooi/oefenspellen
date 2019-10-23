package nl.kooi.domain.game;

import nl.kooi.domain.oefening.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameHelper {

    private static String naamSpeler;
    private static Oefening oefening;
    private static Scanner reader = new Scanner(System.in);
    private static int tafel = 0;
    private static int hoogsteGetal = 0;
    private static int spelkeuze = 0;


    public static void vraagNaam() {
        System.out.println("Wat is je naam?");
        naamSpeler = reader.nextLine();
    }

    public static void vraagSpelkeuzeEnKenmerken() {

        System.out.println("Wat wil je oefenen, " + naamSpeler + "?");
        System.out.println("1. Delen");
        System.out.println("2. Tafels");
        System.out.println("3. Optellen");
        System.out.println("4. Aftrekken");
        System.out.println("5. Vermenigvuldigen");
        spelkeuze = ontvangAntwoordMetMinEnMax(1, 5);

        if (spelkeuze == 2) {
            tafel = stelVraagOntvangAntwoord("Welke tafel wil je oefenen, " + naamSpeler + "?");
        }
        hoogsteGetal = stelVraagOntvangAntwoord("Wat is het hoogste getal dat voor mag komen in de vragen, " + naamSpeler + "?");

        setOefening();
    }

    private static void setOefening() {
        switch (spelkeuze) {
            case 1:
                oefening = new DeelOefening(hoogsteGetal);
                break;
            case 2:
                oefening = new TafelOefening(tafel, hoogsteGetal);
                break;
            case 3:
                oefening = new OptelOefening(hoogsteGetal);
                break;
            case 4:
                oefening = new AftrekOefening(hoogsteGetal);
                break;
            case 5:
                oefening = new VermenigvuldigOefening(hoogsteGetal);
                break;
        }

    }

    public static void stelVraagEnVerwerkAntwoord() {
        int antwoord = 0;

        setOefening();

        while (antwoord > -1) {
            System.out.println();

            antwoord = stelVraagOntvangAntwoord(oefening.toString());

            if (antwoord == oefening.getAntwoord()) {
                System.out.println("Dat klopt, goedzo " + naamSpeler + "!");
                setOefening();
            } else if (antwoord < 0) {
                System.out.println("Bedankt voor het spelen, " + naamSpeler + "! Groetjes van papa");
                break;
            } else {
                System.out.println("Fout! Probeer het nog een keer");
            }
        }
    }

    private static int stelVraagOntvangAntwoord(String vraag) {
        Exception exception;
        int antwoord = 0;

        do {
            try {
                if (vraag != null) System.out.println(vraag);
                antwoord = reader.nextInt();
                exception = null;
            } catch (InputMismatchException e) {
                exception = e;
                System.out.println("Oeps, er ging iets fout! Probeer alleen getallen in te toetsen.");
                reader.next();
            }
        }
        while ((exception != null));

        return antwoord;
    }

    private static int ontvangAntwoord() {
        return stelVraagOntvangAntwoord(null);
    }

    private static int ontvangAntwoordMetMinEnMax(int min, int max) {
        int antwoord;
        antwoord = stelVraagOntvangAntwoord(null);
        while (antwoord < min || antwoord > max) {
            antwoord = stelVraagOntvangAntwoord("Probeer opnieuw. Het antwoord dient minimaal " + min + " en maximaal " + max + " te zijn.");
        }
        return antwoord;
    }
}
