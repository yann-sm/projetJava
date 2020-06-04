import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Echiquier extends JComponent implements KeyListener, ActionListener{
	
	ImageIcon imgTourB, imgTourN, imgCavalierB,  imgCavalierN, imgFouB, imgFouN, imgRoiB, 
			  imgRoiN, imgDameB, imgDameN, imgPionB, imgPionN, imgCases;
	
	// On creé un tableau de chaine de caractere, qui va contenir la place de base, de tous les élément de l'échiquier:
	String[][] pieces = {
						{"NT", "NC", "NF", "ND", "NR", "NF", "NC", "NT"},
						{"NP", "NP", "NP", "NP", "NP", "NP", "NP", "NP"},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null},
						{"BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"},
						{"BT", "BC", "BF", "BD", "BR", "BF", "BC", "BT"}
						};
	
	
	// Constructeur//
	
	Echiquier(){
	 imgTourB = new ImageIcon(getClass().getResource("/image/tour_blanche.png"));
	 imgTourN = new ImageIcon(getClass().getResource("/image/tour_noir.png"));
	 imgCavalierB = new ImageIcon(getClass().getResource("/image/cavalier_blanc.png"));
	 imgCavalierN = new ImageIcon(getClass().getResource("/image/cavalier_noir.png"));
	 imgFouB = new ImageIcon(getClass().getResource("/image/fou_blanche.png"));
	 imgFouN = new ImageIcon(getClass().getResource("/image/fou_noir.png"));
	 imgRoiB = new ImageIcon(getClass().getResource("/image/roi_blanc.png"));
	 imgRoiN = new ImageIcon(getClass().getResource("/image/roi_noir.png"));
	 imgDameB = new ImageIcon(getClass().getResource("/image/dame_blanche.png"));
	 imgDameN = new ImageIcon(getClass().getResource("/image/dame_noir.png"));
	 imgPionB = new ImageIcon(getClass().getResource("/image/pion_blanc.png"));
	 imgPionN = new ImageIcon(getClass().getResource("/image/pion_noir.png"));
	 imgCases = new ImageIcon(getClass().getResource("/image/tour_blanche.png"));
	 
	}
	
	String[][] CoordonneesTab = {
			{"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1" },
			{"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2" },
			{"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3" },
			{"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4" },
			{"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5" },
			{"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6" },
			{"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7" },
			{"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8" },
	};
	
	// Methode de dessin:
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	
		// Instruction de dessin//
		// Les cases de l'echiquier (64):
		int CASE_DIM = 50;
		boolean isWhite = true;
		for(int i = 0; i < 8; i++) { // on def le nb de case en x
			for(int j = 0; j < 8; j++) { // on def le nb de case en y
				if(isWhite) {
					g2.setPaint(Color.WHITE);
				}else {
					g2.setPaint(Color.LIGHT_GRAY);
				}
				// instruction de dessin des diff rect de l'echiquier:
				g2.fill(new Rectangle2D.Double((j+1)*CASE_DIM, (i+1)*CASE_DIM, CASE_DIM, CASE_DIM));
				isWhite = !isWhite; // on modifie la couleur de isWhithe pour que le rect qui suit soit de la couleur opposé,
			}						// en x et en y
			isWhite = !isWhite;
		}
		// le cadre de l'echiquier:
		g2.setPaint(Color.blue);
		g2.setStroke(new BasicStroke(2));// pour donné une largeur de deux pixels
		g2.draw(new Rectangle2D.Double(CASE_DIM, CASE_DIM, 8*CASE_DIM, 8*CASE_DIM));
		
		// Les legendes, en x et y:
		int c;
		for(int i = 0; i < 8; i++) {
			c = i+1+'0';
			g2.setPaint(Color.black);
			g2.drawString("" + (char)c, 2.0f / 3 * CASE_DIM, (i + 1.5f) * CASE_DIM + 6);
		}
		for(int j = 0; j < 8; j = j + 1) {
			c = 'A' + j;
			g2.drawString("" + (char)c, (j + 1.5f) * CASE_DIM - 5,  2.0f / 3 * CASE_DIM + 6);
		}
		// Placer les images des pieces, grace au tableau qui contient une vue 2D de tous les éléments:
		ImageIcon img = null; // on creer une variable image icon, qui est pour le moment egale a null
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(pieces[i][j] != null) {
					if(pieces[i][j].charAt(0) == 'N') {// on regarde le premier caractere grace a charAt(0), ici noir
						if(pieces[i][j].charAt(1) == 'T') { // ici une tour
							img = imgTourN;// image est maintenent egale a tour noir
						}else if(pieces[i][j].charAt(1) == 'C') { // cavalier
							img = imgCavalierN;
						}else if(pieces[i][j].charAt(1) == 'F') { // Fou
							img = imgFouN;
						}else if(pieces[i][j].charAt(1) == 'D') { // Dame
							img = imgDameN;	
						}else if(pieces[i][j].charAt(1) == 'R') { // Roi
							img = imgRoiN;	
						}else { 
							img = imgPionN;	// Pion
						}	
					}else { // pieces Blanche:
						if(pieces[i][j].charAt(1) == 'T') { // ici une tour
							img = imgTourB;
						}else if(pieces[i][j].charAt(1) == 'C') { // cavalier
							img = imgCavalierB;
						}else if(pieces[i][j].charAt(1) == 'F') { // Fou
							img = imgFouB;	
						}else if(pieces[i][j].charAt(1) == 'D') { // Dame
							img = imgDameB;
						}else if(pieces[i][j].charAt(1) == 'R') { // Roi
							img = imgRoiB;
						}else { // cavalier
							img = imgPionB; // Pion
						}	
					}
					// Dessin des diff pieces sur leplateau:
					img.paintIcon(null, g2, (j+1)*CASE_DIM + 10, (i+1)*CASE_DIM + 5);
									// x = numero de la colonne * la taille de la case
									// y = numero de la ligne * la taille de la case
				}
			}
		}
		g2.dispose();
		
	}
	//permet de créé une action par rapport au bouton de notre interface
		public void actionPerformed(ActionEvent e) { 
			System.out.println("ok");
			
		
						
						
						repaint();
					}
							
				
		
			

	
	// KeyListener permet d'associer le clavier au programme
	//il est present dans la classe main pour fonctionner
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
