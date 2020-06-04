package com.ocr.exerciceOPR;

import java.util.Random;
import java.util.Scanner;

public class Guerrier extends Personnages {
    /**
     * Constructeur
     *
     * @param nbLevel
     * @param pointDeVie
     * @param nbStrong
     * @param nbagility
     * @param nbInteligence
     * @param persoEnVie
     */
    public Guerrier(int nbLevel, int pointDeVie, int nbStrong, int nbagility, int nbInteligence, boolean persoEnVie) {
        super(nbLevel, pointDeVie, nbStrong, nbagility, nbInteligence, persoEnVie);
    }

    static Scanner sc = new Scanner(System.in);


    public static int choiceStrike() {
        System.out.println("Choisissez votre actions (1: Attacque basique, 2: Attacque spéciale )");
        int strike = sc.nextInt();
        do {
            if (strike == 1) System.out.println("Utilise coup d'épée et inflige " + getNbStrong() + " de dommages");

            if (strike == 2) System.out.println("Utilise coup de Rage et inflige " + getNbStrong() * 2 + " de dommages et perd de la vitalté : " + getNbStrong() / 2 + "");

            if (strike != 1 && strike != 2) System.out.println("Veuillez choisir une des deux actions possible !!! ");

        } while ( strike != 1 && strike != 2 );
        return strike;
    }
}

