package com.ocr.yann;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class Order {
    Scanner sc = new Scanner(System.in);// on instanci la methode scanner que l'on range dans la variable sc.
                                        // Elle permet de recuperer l'entré de l'utilisateur.
    String orderSummary = ""; // order sumary est un attribut de class
                        // un attribut représente un composant de la class

    /**
     * Display all variable menu
     */
    public void displayAvailableMenu() {
        System.out.println("Choix Menu :");
        System.out.println("1 - Poulet");
        System.out.println("2 - Boeuf");
        System.out.println("3 - Végétarien");
        System.out.println("Que souhaitez-vous comme menu ?");
    }

    /**
     * Display a selected menu
     *
     * @param nbMenu the selected menu
     */
    public void displaySelectedMenu(int nbMenu) {
        if (nbMenu == 1) {
            System.out.println("Vous-avez choisie le poulet");
        } else if (nbMenu == 2) {
            System.out.println("Vous-avez choisie le boeuf");
        } else if (nbMenu == 3) {
            System.out.println("Vos-avez choise le menu végétarien");
        } else {
            System.out.println("Choisissez l'un des trois menu merci...");
        }
    }

    /**
     * Run asking process for menu.
     * boucle do while -> faire tant que.
     */
    public String runMenu() {
        int nbMenu = askMenu();
        int nbSide = -1;
        int nbDrink = -1;
            switch (nbMenu) {
                case 1://menu poulet
                  nbSide = askSide(true);
                  nbDrink = askDrink();
                  break;
                case 2://menu boeuf
                   nbSide = askSide(true);
                   break;
                case 3://menu vegetarien
                   nbSide = askSide(false);
                   nbDrink = askDrink();
                   break;
            }
            return nbMenu +","+nbSide+","+nbDrink+"%n";
        }


    /**
     * Run asking process for several menu
     * ici on demande combien de menu, qui est recuperer dans menuQuantity
     * et tant que counter est inferieur à menuQuantity on appelle la methode menu
     */
    public void runMenus() {
        /**
         *
         */
        Path orderPath = Paths.get("order.csv");
        System.out.println("Combien souhaitez vous commander de menu ?");

        boolean responseIsGood;
        int menuQuantity = 0;
        do {
            try {
                menuQuantity = sc.nextInt();
                responseIsGood = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Vous devez saisir un nombre, correspondant au nombre de menus souhaités");
                responseIsGood = false;
            }
        } while (!responseIsGood);
        orderSummary = "Résumé de votre commande :%n";
        for (int i = 0; i < menuQuantity; i++) {
            orderSummary += "Menu " + (i + 1) + ":%n";
            String orderLine = runMenu();
            try {
                Files.write(orderPath, String.format(orderLine).getBytes(),APPEND);
            } catch (IOException e) {
                System.out.println("ooops, une erreur est survenu, réessayer plus tard...");
                return;//utilisé seul, sert à sortir de la méthode, et donc de quitter le programme.
            }
        }
        System.out.println("");
        System.out.println(String.format(orderSummary));
        /**
         * peut ce faire de differente façon, ici, boucle while :
         *  int counter = 0;
         *  while(counter < menuQuantity) {
         *  	this.runMenu();
         *  	counter = counter + 1;
         *  }
         */

    }


    /**
     * Display a selected side depending on all sides enable or not.
     * all side = vegetarien, fries and rice
     * Not all side = rice or not
     *
     * @param nbSide         the selected side
     * @param allSidesEnable enable display for all sides or not.
     */
    public void displaySelectedSide(int nbSide, boolean allSidesEnable) { // les paramtres sont appellé nbSide et allSidesEnable par défault.
        if (allSidesEnable) {
            switch (nbSide) {
                case 1:
                    System.out.println("Vous avez choisi comme accompagnement : légumes frais");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme accompagnement : frites");
                    break;
                case 3:
                    System.out.println("Vous avez choisi comme accompagnement : riz");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                    break;
            }
        } else {
            switch (nbSide) {
                case 1:
                    System.out.println("Vous avez choisi comme accompagnement : riz");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme accompagnement : pas de riz");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                    break;
            }
        }
    }

    /**
     * Display selected drink
     *
     * @param nbDrink the selected drink
     */
    public void displaySelectedDrink(int nbDrink) {
        switch (nbDrink) {
            case 1:
                System.out.println("Vous-avez choisi comme boisson : eau plate");
                break;
            case 2:
                System.out.println("Vous-avez choisi comme boisson : eau gazeuse");
                break;
            case 3:
                System.out.println("Vous-avez choisi comme boisson : soda");
                break;
            default:
                System.out.println("Vous n'avez pas choisi de boisson parmi les choix proposés");
                break;
        }
    }

    /**
     * Display all available sides depending on all sides enable or not.
     * All sides = vegetariens, frite and rice
     * No all sides = rice or not
     *
     * @param allSideEnable enable display for all side or not
     */
    public void displayAvailableSide(boolean allSideEnable) {
        System.out.println("Choix accompagnement");
        if (allSideEnable) {
            System.out.println("1 - légumes frais");
            System.out.println("2 - frites");
            System.out.println("3 - riz");
        } else {
            System.out.println("1 - riz");
            System.out.println("2 - pas riz");
        }
        System.out.println("Que souhaitez-vous comme accompagnement ?");
    }

    /**
     * Display all available drinks in the restaurant
     */
    public void displayAvailableDrink() {
        System.out.println("Choix accompagnement");
        System.out.println("1 - eau plate");
        System.out.println("2 - eau gazeuse");
        System.out.println("3 - soda");
        System.out.println("Que souhaitez-vous comme boisson ?");
    }

    /**
     * Display a question about a category in the standard input, get response and disply it
     * methode servant a afficher n'importe quelle question.
     *
     * @param category  the category of the question
     * @param responses available responses
     * @return category number selected
     */
    public int askSomething(String category, String[] responses) {
        System.out.println("Choix " + category);
        for (int i = 1; i <= responses.length; i++) { // ici je parcours toutes les reponses possibles
            System.out.println(i + " - " + responses[i - 1]);
        }
        System.out.println("Que souhaitez-vous comme " + category + " ?");
        int nbResponse = 0;
        boolean responsesIsGood;
        do {
            try {
                nbResponse = sc.nextInt();
                responsesIsGood = (nbResponse >= 1 && nbResponse <= responses.length);
            }catch (InputMismatchException e){
                sc.next();// pour vider le scanner de la mauvaise entré de l'utilisateur
                responsesIsGood = false;
            }
            if (responsesIsGood) {
                String choice = "Vous avez choisi comme " + category + " : " + responses[nbResponse - 1];
                orderSummary += choice + "%n";
                System.out.println(choice);
            } else {
                boolean isVowel = "aeiouy".contains(Character.toString(category.charAt(0)));
                if (isVowel)
                    System.out.println("Vous n'avez pas choisi d'" + category + " parmi les choix proposés");
                else
                    System.out.println("Vous n'avez pas choisi de " + category + " parmi les choix proposés");
            }

        } while (responsesIsGood == false); // faire tant que responseIsGood == false.
        return nbResponse;
    }

    /**
     *Display a question about menu in the standard input, get response and disply it
     * @return  menu number selected
     */
    public int askMenu(){
        String[] menus = {"poulet", "boeuf", "végétarien"};
        return askSomething("menu", menus);

    }
    /**
     *Display a question about side in the standard input, get response and disply it
     */
    public int askSide(boolean allSidesEnable){
        if(allSidesEnable){
            String[] responsesAllSide = {"légumes frais", "frites", "riz"};
            return askSomething("accompagnement", responsesAllSide);
        }else{
            String[] responsesOnlyRice = {"riz", "pas de riz"};
            return askSomething("accompagnement", responsesOnlyRice);
        }
    }
    /**
     *Display a question about drink in the standard input, get response and disply it
     */
    public int askDrink(){
        String[] responsesDrink = {"eau plate", "eau gazeuse", "soda"};
        return askSomething("boisson", responsesDrink);
    }
}