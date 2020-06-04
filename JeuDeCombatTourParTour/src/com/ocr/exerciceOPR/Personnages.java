package com.ocr.exerciceOPR;


import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class Personnages {

    static int nbLevel;
    static int pointDeVie;
    static int nbStrong;
    static int nbAgility;
    static int nbInteligence;
    static boolean persoEnVie = true;

    public Personnages(int nbLevel, int pointDeVie, int nbStrong, int nbAgility, int nbInteligence, boolean persoEnVie) {

        this.nbLevel = nbLevel;
        this.pointDeVie = nbLevel*5;
        this.nbStrong = nbStrong;
        this.nbAgility = nbAgility;
        this.nbInteligence = nbInteligence;
        this.persoEnVie = persoEnVie;
    }

    /**
     * Getter
     *
     * @return
     */

    public static int getNbLevel() { return nbLevel; }

    public static int getPointDeVie() { return pointDeVie;}

    public static int getNbStrong() { return nbStrong; }

    public static int getNbagility() { return nbAgility; }

    public static int getNbInteligence() {return nbInteligence; }

    public static boolean PersoEnVie() { return persoEnVie; }





    /**
     * methodes
     */



}



