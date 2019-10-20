package nl.kooi.domain.game;

import nl.kooi.domain.oefening.*;

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
        spelkeuze = reader.nextInt();

        if (spelkeuze == 2) {
            System.out.println("Welke tafel wil je oefenen, " + naamSpeler + "?");
            tafel = reader.nextInt();
        }
        System.out.println("Wat is het hoogste getal dat voor mag komen in de vragen, " + naamSpeler + "?");
        hoogsteGetal = reader.nextInt();

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
            System.out.println(oefening);
            antwoord = reader.nextInt();

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

}
