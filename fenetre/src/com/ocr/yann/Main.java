package com.ocr.yann;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;


public class Main {

    public static void main(String[] args) {
        //création d'une fenetre
	    JFrame fenetre = new JFrame("Ma fenetre");
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// créé la croix pour fermer la fenetre
        fenetre.setSize(750, 440); // taille de la fenetre
        fenetre.setLocationRelativeTo(null); // centrer a l'ecran
        fenetre.setResizable(true); // interdire ou pas le redimenssionement par true ou false
        fenetre.setAlwaysOnTop(true); // pour quel soit au dessus des autres fenetre

        //fenetre.setContentPane() -> pour associé la fenetre a une class que l'on met en parametre


        //gérer le contenu d'une fenetre
        JLabel lab1 = new JLabel("  Bonjour, voici ma première fenêtre Java !!");
        lab1.setBounds(250, 50, 200, 25); // (x, y, largeur, hauteur) pour positioonner notre label dans la fenetre
        lab1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18)); // pour modifier la police
        fenetre.add(lab1);

        fenetre.setVisible(true); // on rend la fenetre visible


    }
}
