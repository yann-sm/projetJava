package fr.jeu2d.fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Clavier implements KeyListener{

	

	@Override
	public void keyPressed(KeyEvent e) {//quand on relache la touche
		if(Main.level.mario.isVivant() == true) {//pour que le clavier reponde mario doit etre vivant
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {//avancer +1 au defilement (fleche droite)//bloquer a gauche
			if(Main.level.getxPos() == -1) {
				Main.level.setxPos(0);	//reinitialisation de setxPos
				Main.level.setxFond1(-50);//reinitialisation de xFond1
				Main.level.setxFond2(690);//reinitialisation de xFond2
			}
			Main.level.mario.setMarche(true);//fait marcher mario en appuyant sur la fleche de droite
			Main.level.mario.setVersDroite(true);//affiche l'image de mario tourné vers la droite
			
			Main.level.setDx(1);	//deplacement du fond vers la gauche lors de l'appui sur la touche "fleche droite".
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {//reculer -1 au defilement (fleche gauche)
			
			if(Main.level.getxPos() == 4431) {//si position est de 4431//bloqué a droite
				Main.level.setxPos(4430);// on retourne a 4430 pour si on veut, repartir a gauche
				Main.level.setxFond1(-50);//et on remet le fond a jour
				Main.level.setxFond2(690);
			}
			
			Main.level.mario.setMarche(true);//fait marcher mario en appuyant sur la fleche de gauche
			Main.level.mario.setVersDroite(false);//affiche l'image de mario tourné vers la gauche
			Main.level.setDx(-1); //deplacement du fond vers la droite lors de l'appui sur la touche 'fleche gauche".
			}
		
		//mario saut
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {//la barre d'espace va d'eclencher l'instruction de saut une fois enfoncé
			Main.level.mario.setSaut(true);
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.level.mario.setMarche(false);//mario arrete de marcher lorsque l'on relache la touche						
		Main.level.setDx(0);		//remise a zero de la variable dx de l'objet scene 
									//lors du relachement des touches
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}	
