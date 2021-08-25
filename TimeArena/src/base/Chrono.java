package base;

import java.util.TimerTask;

public class Chrono extends TimerTask {

	// 5 minutes par joueur
	private int timer = 300;
	
	
	@Override
	public void run() {
		
		// Affichage temps restant
		System.out.println("time : " + timer);
		
		
		// Si temps = 0 renvoyer isfinish ?
		if(timer == 0) {
			cancel();
		} else if
		
		(timer == 298) {
			System.out.println("HEY HO !!!");
		}
		
		// réduit de 1 à chaque fois
		timer --;
	}
	
	// faire une méthode pour stopper le temps
	

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getTimer() {
		return timer;
	}

	@Override
	public String toString() {
		return "timer";
	}

	
	
}