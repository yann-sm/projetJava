package fr.jeu2d.fenetre;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.jeu2d.personnage.Mario;

@SuppressWarnings("serial")
public class Level extends JPanel {
	
	
	//varaible de la class
	//creation du fond:
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
/*	//affiché un personnage:(sans class personnage)
	private ImageIcon icoMario;
	private Image imgMario;*/
	
	//variable gerent la position des differents element:
	private int xFond1;
	private int xFond2;
	private int dx;//gere le deplacement du fond
	private int xPos;//position absolue des differents elements, qui est egale a zero au debut puis grandit
	
	private int ySol;//hauteur courante du sol
	private int hauteurPlaf;//hauteur courante du plafond
	
	public Mario mario;//variable de la class mario pour utiliser la class mario dans la scene
	
	//constructeur//c'est ici que l'on instanci les variables
	public Level() {
		super();//fait reference a la mere class JPanel
		
		//initialisation des variables:
		this.xFond1 = -50;
		this.xFond2 = 690;
		this.dx = 0;
		this.xPos = -1;
		
		this.ySol = 280;
		this.hauteurPlaf = 0;
		
		//initialisation des objets images:
		//Le fond:
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();//fond 1 et 2 sont la meme image
		
	/*	//Le personnage:
		icoMario =new ImageIcon(getClass().getResource("/images/marioArretDroite.png"));
		this.imgMario = this.icoMario.getImage();*/
		mario = new Mario(150, 330);//instanciation de la class mario
		
		this.setFocusable(true);//pour l'ecran
		this.requestFocusInWindow();//pour l'ecran
		this.addKeyListener(new Clavier());//on relie la class clavier a la class level
		
		Thread chronoEcran = new Thread(new Chrono());//ici on creer une instance de chrono qui fait défiler le fond a l'infini
		chronoEcran.start();
		
	}	
	//getters et setters
	public int getxFond1() {return xFond1;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public int getxFond2() {return xFond2;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

	public int getDx() {return dx;}

	public void setDx(int dx) {this.dx = dx;}

	public int getxPos() {return xPos;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	public int getySol() {return ySol;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public int getHauteurPlaf() {return hauteurPlaf;}
	
	public void setHauteurPlaf(int hauteurPlaf) {this.hauteurPlaf = hauteurPlaf;}
		
	
	
	//methode qui va gerer le deplacement du fond:
	public void deplacementFond() {//deplacement des images "fixe" de l'ecran simulant le deplacemnt du personnage
		
		if(this.xPos >= 0 && this.xPos <= 4430) {
			//
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
		//permanence du fond d'ecran:
		if(this.xFond1 == - 690) {this.xFond1 = 690;}//permet d'avoir le meme fond en continu
		else if(this.xFond2 == -690) {this.xFond2 = 690;}
		else if(this.xFond1 == 690) {this.xFond2 = -690;}
		else if(this.xFond2 == 690) {this.xFond2 = -690;}
	}
	
	
		
	//methode de dessin:
		public void paintComponent(Graphics g) {//dessin de toutes les images visibles a l'ecran (appel toutes les 3ms environ)
			
			super.paintComponent(g);
			Graphics g2 = (Graphics2D)g;
			
			this.deplacementFond();
			
			//dessin des images de fonds:
			g2.drawImage(this.imgFond1, this.xFond1, 0, null);//dessin de l'image de fond1
			g2.drawImage(this.imgFond2, this.xFond2, 0, null);//dessin de l'image de fond2
			
			//dessin du personnage:
		//	g2.drawImage(imgMario, 150, 330, null);
			if(this.mario.isVivant() == true) {//PROBLEME LIGNE 129.....
				if(this.mario.isSaut()) {g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);}
				else {g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);}
			}else {g2.drawImage(this.mario.meurt(), this.mario.getX(), this.mario.getY(), null);}//affiche la mort de mario
			
		}
	
		
	}


