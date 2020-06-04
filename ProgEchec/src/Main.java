import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Main extends JFrame {

	


	//constructeur (a le meme nom que la classe)//
	Main(){ //
		setTitle("-- Jeu d'échecs --");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		
		
		//Contenu//
		// Couleur du joueur:
		JLabel labelCouleur = new JLabel("Votre couleur : ");
		labelCouleur.setBounds(500, 50, 200, 25); // (x, y, largeur, hauteur) pour positioonner notre label dans la fenetre
		labelCouleur.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18)); //pour modifier la police
		add(labelCouleur); //pour ajouter le label a l'interface graphique
		
		JLabel labelCouleurV = new JLabel("Noir");
		labelCouleurV.setBounds(675, 50, 200, 25);
		labelCouleurV.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		add(labelCouleurV);
		
		// Zone de saisie de texte pour case de depart:
		JTextField tfCaseDep = new JTextField(); //creer la zone de saisie de la case de depart
		tfCaseDep.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		tfCaseDep.setBounds(500, 150, 60, 45);
		add(tfCaseDep);
		//on ajoute un texte au desssus de la zone de saisie:
		JLabel caseDepLbl = new JLabel("Origine");
		caseDepLbl.setFont(new Font(Font.DIALOG, Font.ITALIC, 10));
		caseDepLbl.setBounds(510, 130, 50, 15);
		add(caseDepLbl);
		
		// Zone de saisie de texte pour case d'arrivée:
		JTextField tfCaseArr = new JTextField();// pour entrer coordonnée de la case d'arrivé
		tfCaseArr.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		tfCaseArr.setBounds(580, 150, 70, 45);
		add(tfCaseArr);
		//on ajoute un texte au desssus de la zone de saisie:
		JLabel caseArrLbl = new JLabel("Destination");
		caseArrLbl.setFont(new Font(Font.DIALOG, Font.ITALIC, 10));
		caseArrLbl.setBounds(585, 130, 50, 15);
		add(caseArrLbl);
		
		//bouton vers..:// pour creer un bouton:
		JButton btnDeplacement = new JButton();
		btnDeplacement.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
		btnDeplacement.setText("GO");
		btnDeplacement.setBounds(675, 150, 60, 45);
		add(btnDeplacement);
		
		// Echiquier:
		Echiquier ecq = new Echiquier();
		ecq.setBounds(10, 10, 452, 465);
		add(ecq);
		
		btnDeplacement.addActionListener(ecq);// on demande au bouton d'etre a l'ecoute de actionListener
										// ecq fait reference a la classe echiquier
		addKeyListener(ecq);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				new Main().setVisible(true);}
			
		});
	}
	
}


































