package com.ocr.yann;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * On va maintenant coder un second programme qui va lire notre fichier CSV.
 * Dans ce programme, on va ouvrir le fichier order.csv puis afficher l'ensemble des commandes inscrites à l'intérieur.
 *
 * Nous allons procéder de la façon suivante :
 *  Ajoutez une nouvelle classe dédiée : clic droit sur le package contenant votre  Main  (chez moi com.ocr.anthony), puis New > Java Class . Nommez-la OrderReader .
 *  Dans ce fichier, saisissez psvm puis ↵, cela va automatiquement créer une nouvelle méthode  main .
 *  Créez une méthode  read .
 *  Créez une variable  Path  vers le fichier order.csv .
 *  Ignorez la première ligne du fichier (les titres).
 *  Pour chaque ligne du fichier, affichez le détail de la commande.
 *  Enfin dans le  main , utilisez  read.
 */
public class OrderReader {
    public void read(){
        Path orderPath = Paths.get("order.csv");// on créer une variable de Path vers le fichier order.csv.
        List<String> lines = null;// null mean no value by default
        try{
            lines = Files.readAllLines(orderPath);
        }catch (IOException e){
            System.out.println("Impossible de lire le fichier des commandes");
        }
        if(lines.size() < 2){
            System.out.println("Il n'y a pas de commande dans le fichier");
            return;
        }
        String[] menus = {"Menu poulet", "Menu boeuf", "Menu végétarien"};
        String[] side = {" avec légumes frais", " avec des frites", " avec du riz"};
        String[] sideVegetarian = {" avec du riz", " sans riz"};
        String[] drink = {" et avec de l'eau plate", " et avec de l'eau gazeuse", " et avec du soda"};

        for(int i = 1; i < lines.size(); i++){
            String[] split = lines.get(i).split(",");
            int nbMenu = Integer.valueOf(split[0]);
            int nbSide = Integer.valueOf(split[1]);
            int nbDrink = Integer.valueOf(split[2]);
            String orderLine = menus[nbMenu - 1];
            if(nbMenu == 3)// végétarian menu
                orderLine += sideVegetarian[nbSide - 1];
            else
                orderLine += side[nbSide -1];
            if(nbDrink == - 1)
                orderLine += " et sans boisson";
            else
                orderLine += drink[nbDrink - 1];
            System.out.println(orderLine);
        }

    }

    public static void main(String[] args) {
        OrderReader orderReader = new OrderReader();
        orderReader.read();
    }
}
