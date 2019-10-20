package nl.kooi.domain.game;

import nl.kooi.domain.oefening.*;

import java.util.Scanner;

public class GameHelper {

    private static String naamSpeler;
    private static Oefening oefening;
    private static Scanner reader = new Scanner(System.in);

    public static void vraagNaam() {
        System.out.println("Wat is je naam?");
        naamSpeler = reader.nextLine();
    }

    public static void vraagSpelkeuzeEnKenmerken() {
        int hoogsteGetal;
        int spelkeuze;

        System.out.println("Wat wil je oefenen, " + naamSpeler + "?");
        System.out.println("1. Delen");
        System.out.println("2. Tafels");
        System.out.println("3. Optellen");
        System.out.println("4. Aftrekken");
        System.out.println("5. Vermenigvuldigen");
        spelkeuze = reader.nextInt();

        System.out.println("Wat is het hoogste getal dat voor mag komen in de vragen, " + naamSpeler + "?");
        hoogsteGetal = reader.nextInt();

        setSpelkeuze(spelkeuze, hoogsteGetal);
    }

    private static void setSpelkeuze(int spelkeuze, int hoogsteGetal) {
        int tafel;

        switch (spelkeuze) {
            case 1:
                oefening = new DeelOefening(hoogsteGetal);
                break;
            case 2:
                System.out.println("Welke tafel wil je oefenen, " + naamSpeler + "?");
                tafel = reader.nextInt();

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

        oefening.setVraag();

        while (antwoord > -1) {
            System.out.println();
            oefening.printVraag();
            antwoord = reader.nextInt();

            if (antwoord == oefening.getAntwoord()) {
                System.out.println("Dat klopt, goedzo " + naamSpeler + "!");
                oefening.setVraag();

            } else if (antwoord < 0) {
                System.out.println("Bedankt voor het spelen, " + naamSpeler + "! Groetjes van papa");
                break;

            } else {
                System.out.println("Fout! Probeer het nog een keer");

            }
        }

    }

}
