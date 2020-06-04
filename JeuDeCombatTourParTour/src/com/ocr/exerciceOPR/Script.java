package com.ocr.exerciceOPR;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Script {
    Scanner sc = new Scanner(System.in);


    /**
     *
     */

    public void runGame() {

        Playeur1.displaySelectedPerso();
        System.out.println("");
        Playeur2.displaySelectedPerso();
        System.out.println("");

        System.out.println("Phase de combat :");
        do {
            Playeur1.strike();
            Playeur2.strike();

            if(Playeur1.persoVie == 0 || Playeur1.persoVie < 0){
                Personnages.persoEnVie = false;
                System.out.println("Playeur 1 est mort, Playeur2 GAGNE !!!!");
            }
            else if (Playeur2.persoVie == 0 || Playeur2.persoVie < 0){
                Personnages.persoEnVie = false;
                System.out.println("Playeur 2 est mort, Playeur1 GAGNE !!!!");
            }
        }while ( Personnages.persoEnVie != false );
        return;
    }
}