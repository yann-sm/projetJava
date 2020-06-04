package fr.jeu2d.fenetre;

public class Chrono implements Runnable{

	private final int PAUSE = 3;//temps d'attente entre deux tours de boucles
	
	@Override
	public void run() {//methode de boucle infini
		
		while(true) {
			Main.level.repaint();//appel de la methode PaintComponent de l'objet level
			//System.out.println("ok");//permet de vérifier que l'instruction est executé normalement
			try {
				Thread.sleep(PAUSE);//temp de pause du flux (3ms)(thread pour flux)
			} catch (InterruptedException e) {}
		}
		
	}

}
