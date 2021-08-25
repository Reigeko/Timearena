package base;

public class Hero {
	private String color;
	private int move;
	private int attack;
	private int defense;
	private int maxRespawnTimer;
	
	public Hero(String color, int move, int attack, int defense, int maxRespawnTimer) {
		this.color = color;
		this.move = move;
		this.attack = attack;
		this.defense = defense;
		this.maxRespawnTimer = maxRespawnTimer;
	}

	public void TakeDamage(int damage) {
		defense -= attack;
		
		if(defense <= 0) {
			Die();
		}
	}
	
	void Die() {
		System.out.println("Le joueur est mort");
		// déclencher le timer du hero
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMaxRespawnTimer() {
		return maxRespawnTimer;
	}

	public void setMaxRespawnTimer(int maxRespawnTimer) {
		this.maxRespawnTimer = maxRespawnTimer;
	}

	@Override
	public String toString() {
		return "Hero Couleur : " + color + ", Points de mouvements : " + move + ", Attaque : " + attack + ", Defense : " + defense
				+ ", Temps de respawn : " + maxRespawnTimer + "";
	}
	
	
}
