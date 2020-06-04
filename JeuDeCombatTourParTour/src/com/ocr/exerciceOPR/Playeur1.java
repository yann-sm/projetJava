package com.ocr.exerciceOPR;

import java.util.Scanner;

import static com.ocr.exerciceOPR.Guerrier.choiceStrike;
import static com.ocr.exerciceOPR.Personnages.*;
import static java.lang.System.*;

public class Playeur1 {

    static Scanner sc = new Scanner(in);
    public static int choixPerso1;
    public static int persoVie;
    public static int persoLevel;
    public static int persoForce;
    public static int persoAgility;
    public static int persoInteligence;

    /**
     *
     */

    public static int displaySelectedPerso() {
        out.println("Création du personnage du joueur 1 :");

        do {
            choixPerso1 = 0;
            out.println("Veuillez choisir la classe de votre personnage (1 - Le Mage, 2 - Le Guerrier, 3 - Le Rodeur)");
            choixPerso1 = sc.nextInt();

            if(choixPerso1 != 1 && choixPerso1 != 2 && choixPerso1 != 3 ){
                out.println("Choisissez uniquement l'une des trois classes !!!");
            }
        } while ( choixPerso1 != 1 && choixPerso1 != 2 && choixPerso1 != 3 );


        do{
            out.println("Niveau du personnage ?");
            persoLevel = Personnages.nbLevel = sc.nextInt();
            persoVie = Personnages.pointDeVie = Personnages.nbLevel*5;
            out.println("Force du personnages ?");
            persoForce = Personnages.nbStrong = sc.nextInt();
            out.println("Agilité du personnage ?");
            persoAgility = Personnages.nbAgility = sc.nextInt();
            out.println("Intéligence du personnage ?");
            persoInteligence = Personnages.nbInteligence = sc.nextInt();

            if (Personnages.nbStrong + Personnages.nbAgility + Personnages.nbInteligence != Personnages.nbLevel){
                out.println("La somme des points distribué doit être égale au Niveau du personnage !!!");
            }

        }while ( Personnages.nbStrong + Personnages.nbAgility + Personnages.nbInteligence != Personnages.nbLevel  );

        if ( choixPerso1 == 1){
            out.println("Abracadabra je suis le Mage joueur1, niveau " + persoLevel + ", je possède " + persoVie + " de vitalité, force " + persoForce + ", agilité " + persoAgility + ", intelligence " + persoInteligence + "!");
        }
        if ( choixPerso1 == 2){
            out.println("Woarg je suis le guerrier joueur1, niveau " + persoLevel + ", je possède " + persoVie + " de vitalité, force " + persoForce + ", agilité " + persoAgility + ", intelligence " + persoInteligence  + "!");
        }
        if ( choixPerso1 == 3){
            out.println("Je suis le rôdeur joueur1, niveau " + persoLevel + ", je possède " + persoVie + " de vitalité, force " + persoForce + ", agilité " + persoAgility + ", intelligence " + persoInteligence + "!");
        }
        return choixPerso1;
    }



    /**
     * methodes pour les attaques
     * @return
     */


    public static void strike() {
        out.println("Playeur1 ("+Playeur1.persoVie+" de vitalité )");
        if ( choixPerso1 == 1){
            if (MageChoiceStrike() == 1) {
                Playeur2.persoVie = Playeur2.persoVie - persoInteligence;

            }
                else { Playeur1.persoVie = Playeur1.persoVie + (Playeur1.persoInteligence * 2);}

        }

        if ( choixPerso1 == 2) {
            if (GuerrierChoiceStrike() == 1) {
                Playeur2.persoVie = Playeur2.persoVie - Playeur1.persoForce;
            }
            else {
                Playeur2.persoVie = Playeur2.persoVie - (Playeur1.persoForce * 2);
                Playeur1.persoVie = Playeur1.persoVie - (Playeur1.persoForce / 2);
            }


        if ( choixPerso1 == 3){
            if (RodeurChoiceStrike() == 1) {
                Playeur2.persoVie = Playeur2.persoVie - Playeur1.persoAgility;
            }
            else { Playeur1.persoAgility = Playeur1.persoAgility + (Playeur1.persoLevel / 2); }
        }

    }
}

    public static int MageChoiceStrike(){

        System.out.println("Choisissez votre actions (1: Attacque basique, 2: Attacque spéciale )");
        int Magestrike = sc.nextInt();
        do {
            if (Magestrike == 1) System.out.println("Utilise Boule de feu et inflige " + Playeur1.persoInteligence + " de dommages");

            if (Magestrike == 2) System.out.println("Utilise Soins et regagne " + Playeur1.persoInteligence * 2 + " de vie ");

            if (Magestrike != 1 && Magestrike != 2) System.out.println("Veuillez choisir une des deux actions possible !!! ");

        } while ( Magestrike != 1 && Magestrike != 2 );
        return Magestrike;
    }


    public static int GuerrierChoiceStrike() {
        System.out.println("Choisissez votre actions (1: Attacque basique, 2: Attacque spéciale )");
        int GuerrierStrike = sc.nextInt();
        do {
            if (GuerrierStrike == 1) System.out.println("Utilise coup d'épée et inflige " + Playeur1.persoForce + " de dommages");

            if (GuerrierStrike == 2) System.out.println("Utilise coup de Rage et inflige " + Playeur1.persoForce * 2 + " de dommages et perd de la vitalté : " + Playeur1.persoForce / 2 + "");

            if (GuerrierStrike != 1 && GuerrierStrike != 2) System.out.println("Veuillez choisir une des deux actions possible !!! ");

        } while ( GuerrierStrike != 1 && GuerrierStrike != 2 );
        return GuerrierStrike;
    }


    public static int RodeurChoiceStrike(){

        System.out.println("Choisissez votre actions (1: Attacque basique, 2: Attacque spéciale )");
        int RodeurStrike = sc.nextInt();
        do {
            if (RodeurStrike == 1) System.out.println("Utilise Tire à l'Arc et inflige " + Playeur1.persoAgility + " de dommages");

            if (RodeurStrike == 2) System.out.println("Utilise concentration et gagne " + Playeur1.persoAgility / 2 + " d'agilité ");

            if (RodeurStrike != 1 && RodeurStrike != 2) System.out.println("Veuillez choisir une des deux actions possible !!! ");

        } while ( RodeurStrike != 1 && RodeurStrike != 2 );
        return RodeurStrike;
    }
}


