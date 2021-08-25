package base;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	boolean playtime = true;
	
	private List<Hero> playerhero = new ArrayList<Hero>();
	
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Hero> getPlayerhero() {
		return playerhero;
	}

	public void setPlayerhero(List<Hero> playerhero) {
		this.playerhero = playerhero;
	}

	public void showHeroList() {
		for (Hero hero : playerhero) {
			System.out.println(hero.toString());
		}
	}
	
}
