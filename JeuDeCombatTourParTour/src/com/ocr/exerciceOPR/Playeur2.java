package com.ocr.exerciceOPR;

import java.util.Scanner;
import static com.ocr.exerciceOPR.Guerrier.choiceStrike;
import static com.ocr.exerciceOPR.Personnages.*;
import static java.lang.System.out;

public class Playeur2 {

    static Scanner sc = new Scanner(System.in);
    public static int choixPerso;
    public static int persoVie;
    public static int persoLevel;
    public static int persoForce;
    public static int persoAgility;
    public static int persoInteligence;


    /**
     * Display all available personnage /
     */


    public static int displaySelectedPerso() {

        //Choix du personnage parmi les trois possibles :
        out.println("Création du personnage du joueur 2 :");

        do {
            choixPerso = 0;
            out.println("Veuillez choisir la classe de votre personnage (1 - Le Mage, 2 - Le Guerrier, 3 - Le Rodeur)");
            choixPerso = sc.nextInt();

            if(choixPerso != 1 && choixPerso != 2 && choixPerso != 3){
                out.println("Choisissez uniquement l'une des trois classes !!!");
            }
        } while ( choixPerso != 1 && choixPerso != 2 && choixPerso != 3 );


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

        if ( choixPerso == 1){
            out.println("Abracadabra je suis le Mage joueur2, niveau " + Personnages.nbLevel + ", je possède " + Personnages.pointDeVie + " de vitalité, force " + Personnages.nbStrong + ", agilité " + Personnages.nbAgility + ", intelligence " + Personnages.nbInteligence + "!");
        }
        if ( choixPerso == 2){
            out.println("Woarg je suis le guerrier joueur2, niveau " + Personnages.nbLevel + ", je possède " + Personnages.pointDeVie + " de vitalité, force " + Personnages.nbStrong + ", agilité " + Personnages.nbAgility + ", intelligence " + Personnages.nbInteligence + "!");
        }
        if ( choixPerso == 3){
            out.println("Je suis le rôdeur joueur2, niveau " + Personnages.nbLevel + ", je possède " + Personnages.pointDeVie + " de vitalité, force " + Personnages.nbStrong + ", agilité " + Personnages.nbAgility + ", intelligence " + Personnages.nbInteligence + "!");
        }

        return choixPerso;
    }


    public static void strike() {
        out.println("Playeur2 ("+Playeur2.persoVie+" de vitalité )");
        if ( choixPerso == 1){
            if (Mage.choiceStrike() == 1) {
                Playeur1.persoVie = Playeur1.persoVie - persoInteligence;
            }
            else { Playeur2.persoVie = Playeur2.persoVie + (Playeur2.persoInteligence * 2);}

        }

        if ( choixPerso == 2){
            if (Guerrier.choiceStrike() == 1) {
                Playeur1.persoVie = Playeur1.persoVie - Playeur2.persoForce;
            }
            else {
                Playeur1.persoVie = Playeur1.persoVie - (Playeur2.persoForce * 2);
                Playeur2.persoVie = Playeur2.persoVie - (Playeur2.persoForce / 2);
            }

        }

        if ( choixPerso == 3){
            if (Rodeur.choiceStrike() == 1) {
                Playeur1.persoVie = Playeur1.persoVie - Playeur2.persoAgility;
            }
            else { Playeur2.persoAgility = Playeur2.persoAgility + (Playeur2.persoLevel / 2); }
        }

    }

}
