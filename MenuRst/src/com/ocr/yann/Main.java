package com.ocr.yann;

public class Main {

    public static void main(String[] args) {

        //ici on créé une instance de order pour pouvoir utiliser ce qui se trouve dans la class order
        // dans la class main.
        Order order = new Order();
        order.runMenus(); // on appelle la methode runMenus pour affiché le menu
    }
}


 /*
 Un fichier CSV ou Comma-Separated Values est un simple fichier texte dans lequel on sauvegarde des données.
 Celles-ci sont séparées par des virgules, et des retours à la ligne↵.
 Le fichier porte l'extention .csv.

 Ce fichier peut servir à stocker :

 les personnes interrogées dans le cadre d'une étude ;
 les clients d'un magasin ;
 les produits disponibles dans un catalogue ;
 les films à l'affiche d'un cinéma ;
 etc.
 On peut mettre tout et n'importe quoi dans un fichier csv. Le fichier commence en mettant sur la première ligne les titres de chaque information.
 Puis, en suivant sur chaque ligne, les informations voulues (en veillant à respecter l'ordre des titres).

 Dans notre cas, nous allons utiliser notre fichier pour sauvegarder l'ensemble des commandes de notre menu interactif.


 À quoi ce fichier va ressembler ?
 On va se contenter d'un format simple.

menu,accompagnement,boisson
2,1,1
1,2,1
3,2,2

Pour chaque ligne on a :

le numéro du menu ;
le numéro de l'accompagnement ;
le numéro de la boisson (-1 s'il n'y en a pas).
Java est composé de centaines d'outils. Avec un de ces outils on peut ouvrir, lire et écrire dans un fichier.

Pour écrire dans un fichier, il faut créer une variable de type Path contenant le chemin vers votre fichier.

jshell> Path orderPath = Paths.get("order.csv");
orderPath ==> order.csv
On va maintenant créer notre fichier et écrire dedans.

jshell> Files.write(orderPath, String.format("menu,accompagnement,boisson%n").getBytes());
$6 ==> order.csv
Si je regarde le contenu du dossier dans lequel j'ai lancé JShell, il y a bien un fichier test.csv
contenant menu,accompagnement,boisson :

~ > cat order.csv
menu,accompagnement,boisson
Utilisons ces outils pour créer le fichier order.csv avec notre application.


Quelques indices pour une solution propre :

cette fois-ci pas besoin d'attribut ;
on va créer le  Path  dans runMenus ;
askSide  et  askDrink  doivent eux aussi retourner le numéro du choix ;
avec ça, il reste à utiliser  Files.write  à la fin de  runMenus.
On part du principe que le fichier existe déjà et contient les titres.
echo "menu,accompagnement,boisson" > order.csv
On commence à entrer dans des fonctionnalités avancées de Java. Pour pouvoir tester l'écriture dans un fichier proprement,
 il faudrait utiliser de l'injection et des mocks.
 Le cours sur les tests unitaires explique ces principes.

Pour cette raison, pas de test cette fois-ci. C'est une mauvaise pratique ! Ce sera l'occasion pour vous de voir que sans tests codés en amont,
 on n'est pas sûr de respecter le bon comportement.
 Surtout vous pouvez complètement casser votre code sans avoir d'alerte.
Par défaut  Files.write  écrase votre fichier. Pour ne pas écraser le fichier, mais pour y ajouter du contenu,
il faut donner un paramètre supplémentaire à  Files.write  :

Files.write(orderPath, orderLine.getBytes(), APPEND);

Pensez à ajouter les titres à la première ligne et une ligne vide.
  */