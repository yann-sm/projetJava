package com.ocr.exerciceOPR;

import java.util.Scanner;

public class Mage extends Personnages{

    static Scanner sc = new Scanner(System.in);

    public Mage(int nbLevel, int pointDeVie, int nbStrong, int nbagility, int nbInteligence, boolean persoEnVie) {
        super(nbLevel, pointDeVie, nbStrong, nbagility, nbInteligence, persoEnVie);
    }

    public static int choiceStrike(){

        System.out.println("Choisissez votre actions (1: Attacque basique, 2: Attacque spéciale )");
        int strike = sc.nextInt();
        do {
            if (strike == 1) System.out.println("Utilise Boule de feu et inflige " + getNbInteligence() + " de dommages");

            if (strike == 2) System.out.println("Utilise Soins et regagne " + getNbInteligence() * 2 + " de vie ");

            if (strike != 1 && strike != 2) System.out.println("Veuillez choisir une des deux actions possible !!! ");

        } while ( strike != 1 && strike != 2 );
        return strike;
    }
}



