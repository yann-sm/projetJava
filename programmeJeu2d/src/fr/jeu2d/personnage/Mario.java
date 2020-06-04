package fr.jeu2d.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import fr.jeu2d.fenetre.Main;



public class Mario extends Personnages {

	//variables:
	private Image imgMario;
	private ImageIcon icoMario;
	private boolean saut;//vrai si mario saute
	private  int compteurSaut;//durée du saut et la hauteur
	private int compteurMort;
	
	
	//constructeur:
	public Mario( int x, int y) {
		super(28, 50, x, y);
		this.icoMario = new ImageIcon(getClass().getResource("/images/marioArretDroite.png"));
		this.imgMario = this.icoMario.getImage();
		
		this.saut = false;
		this.compteurSaut = 0;
		this.compteurMort = 0;
	}
	//getters and setters//permet d'obtenir et de modifier
		public Image getImgMario() {return imgMario;}
		
		public boolean isSaut() {return saut;}
			
		public void setSaut(boolean saut) {this.saut = saut;}
			
		//methode marche pour mario
		@Override
		public Image marche(String nom, int frequence) {
			
			String str;
			ImageIcon ico;
			Image img;
			
			if(this.marche == false || Main.level.getxPos() <= 0 || Main.level.getxPos() > 4430) {//si le personnage est arreter ou completement a gauche
				if(this.versDroite == true) {//si vers la droite image de droite
					str = "/images/" + nom + "ArretDroite.png";
				}else {str = "/images/" + nom + "ArretGauche.png";}//si non image de gauche
			}else {//ou le personnage se deplace, on incremente donc le compteur a chaque fois que la  scene est redessiné
				this.compteur++;
				if(this.compteur / frequence == 0) {//si compteur/par frequence est = a 0 c'est que le personnage est a l'arret donc:
					if(this.versDroite == true) {str = "/images/" + nom + "ArretDroite.png";
					}else {str = "/images/" + nom + "ArretGauche.png";}
				}else {	//si non c'est que le personnage se deplace:
					if(this.versDroite == true) {str = "/images/" + nom + "MarcheDroite.png";
					}else {str = "/images/" + nom + "MarcheGauche.png";}
				}
				if(this.compteur == 2 * frequence) {this.compteur = 0;}//si compteur est = a 2fois la frequence ont remet le compteur a zero	
			}
			//affichage de l'image du personnage
			ico = new ImageIcon(getClass().getResource(str));//TROUVER LE PROBLEME LIÉ A CETTE LIGNE.....
			img = ico.getImage();
			return img;	
					
		}
		//methodes pour que mario puisse sauté
		public Image saute() {
			
			ImageIcon ico;
			Image img;
			String str;
			
			this.compteurSaut++;
			//montée du saut
			if(this.compteurSaut <= 35) {
				if(this.getY() > Main.level.getHauteurPlaf()) {this.setY(this.getY() - 4);}//getY corespond au sommet de la tete de mario
				else {this.compteurSaut = 36;}												//get hauteurPlafond correspond a la hauteur max que l'on peut atteindre
				if(this.isVersDroite() == true) {str = "/images/marioSautDroite.png";}//si tournée vers la droite image de saut droite
				else {str = "/images/marioSautGauche.png";}//si non image saut gauche
				
			//retombé du saut
			}else if(this.getY() - this.getHauteur() < Main.level.getySol()) {this.setY(this.getY() + 1);
				if(this.isVersDroite() == true) {str = "/images/marioSautDroite.png";}
				else {str = "/images/marioSautGauche.png";}
				
			//saut terminé
			}else {
				if(this.isVersDroite() == true) {str = "/images/marioArretDroite.png";}
				else {str = "/images/marioArretGauche.png";}
				this.saut = false;
	   			this.compteurSaut = 0;
			}
			//affichage de l'image de mario
			ico = new ImageIcon(getClass().getResource(str));
			img = ico.getImage();
			return img;
			
		}
	
		//methode qui va gerer la mort de mario
		public Image meurt() {
			String str;//va contenir le nom de l'image
			ImageIcon ico;//nom de la nouvelle instance de la methode ImageIcon
			Image img;//va etre egale a ico, et va retourner l'image voulu
			
			str = "/images/bouleDeFeu.png";
			this.compteurMort++;//on incremente un compteur
			if(this.compteurMort > 100) {//si le compteur arrive jusqu'a 100, mario meurt, 
				str = "/images/mortDEMario.png";//donc on change d'image
				this.setY(this.getY() - 1);//fait monter l'image de la mort de mario vers le ciel
			}
			ico = new ImageIcon(getClass().getResource(str));
			img = ico.getImage();
			return img;
		}		
}
