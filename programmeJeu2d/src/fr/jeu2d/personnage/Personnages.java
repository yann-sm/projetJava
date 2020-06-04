package fr.jeu2d.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Personnages {

	//Variables:
	private int largeur, hauteur;//dimenssion des personnages
	private int x, y;//position des personnages
	protected boolean marche;//vrai quand le personnage marche
	public boolean versDroite;//vrai quand le personnage est tourné vers la droite
	public int compteur;//compteur des pas du personnage
	protected boolean vivant; //vrai si le personnage est vivant
	
	//Constructeur:
	public Personnages(int largeur, int hauteur, int x, int y) {
		
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
		this.marche = false;
		this.versDroite = true;
		this.compteur = 0;
		this.vivant =  true;
		
	}
	//Getters and setters:	
	
	public int getX() {return x;}

	public void setX(int x) {this.x = x;}

	public int getY() {return y;}

	public void setY(int y) {this.y = y;}
		
	public boolean isMarche() {return marche;}
		
	public void setMarche(boolean marche) {this.marche = marche;}

	public boolean isVersDroite() {return versDroite;}
	
	public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

	public int getCompteur() {return compteur;}

	public void setCompteur(int compteur) {this.compteur = compteur;}

	public int getLargeur() {return largeur;}
	
	public int getHauteur() {return hauteur;}
	
	public boolean isVivant() {return vivant;}

	public void setVivant(boolean vivant) {this.vivant = vivant;}
	
	
	//methodes pour les deplacements des personnages, qui va renvoyer l'image du personnage qui marche
	//cette methodes prend en argument le nom du personnage, ainsi que la frequence des pas du personnage
	public Image marche(String nom, int frequence) {
		
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.marche == false ) {//|| Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4430) {//si le personnage est arreter ou completement a gauche
			if(this.versDroite == true) {//si vers la droite image de droite
				str = "/image/" + nom + "ArretDroite.png";
			}else {str = "/image/" + nom + "ArretGauche.png";}//si non image de gauche
		}else {//ou le personnage se deplace, on incremente donc le compteur a chaque fois que la  scene est redessiné
			this.compteur++;
			if(this.compteur / frequence == 0) {//si compteur/par frequence est = a 0c'esst que le personnage est a l'arret donc:
				if(this.versDroite == true) {str = "/image/" + nom + "ArretDroite.png";
				}else {str = "/image/" + nom + "ArretGauche.png";}
			}else {	//si non c'est que le personnage se deplace:
				if(this.versDroite == true) {str = "/image/" + nom + "MarcheDroite.png";
				}else {str = "/image/" + nom + "MarcheGauche.png";}
			}
			if(this.compteur == 2 * frequence) {this.compteur = 0;}//si compteur est = a 2fois la frequence on remet le compteur a zero			
		}
		//affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;	
		
	}
	
	
	
}
