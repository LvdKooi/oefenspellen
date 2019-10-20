package nl.kooi.oefenspellen;

import nl.kooi.domain.*;

import java.util.Scanner;

public class OefenspellenApplication {

    private static String naamSpeler;
    private static int hoogsteGetal;
    private static int antwoord;
    private static int spelkeuze;
    private static int tafel;
    private static Oefening oefening;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Wat is je naam?");
        naamSpeler = reader.nextLine();

        System.out.println("Wat wil je oefenen, " + naamSpeler + "?");
        System.out.println("1. Delen");
        System.out.println("2. Tafels");
        System.out.println("3. Optellen");
        System.out.println("4. Aftrekken");
        spelkeuze = reader.nextInt();

        if (spelkeuze == 2) {
            System.out.println("Welke tafel wil je oefenen, " + naamSpeler + "?");
            tafel = reader.nextInt();
        }
        System.out.println("Wat is het hoogste getal dat voor mag komen in de vragen, " + naamSpeler + "?");
        hoogsteGetal = reader.nextInt();


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
        }


        oefening.setVraag();
        while (antwoord > -1) {

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
