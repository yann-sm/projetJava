package fr.jeu2d.fenetre;

import javax.swing.JFrame;

public class Main {

	
	public static Level level;

	//methodes
	public static void main(String[] args) {
		
		//creation d'une fenetre
		JFrame fenetre = new JFrame("-- donner un nom --");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//creer la croix pour fermer la fenetre
		fenetre.setSize(700, 440);//taille de la fenetre
		fenetre.setLocationRelativeTo(null);//centrer a l'ecran
		fenetre.setResizable(false);//interdire le redimenssionement
		fenetre.setAlwaysOnTop(true);//pour quel soit au-dessus des autres fenetres
		
		//instanciation de l'objet level:
		level = new Level();
		
		fenetre.setContentPane(level);//on associt la fenetre a la class level
		fenetre.setVisible(true);//on rend la fenetre visible
		
		
	}

}
