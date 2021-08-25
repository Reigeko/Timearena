package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import tools.Coordonees;

import java.util.Scanner;

public class Main {
	
	private static int TIMERMAX = 300;
	private static int BOARD_SIZE_H = 8;
	private static int BOARD_SIZE_W = 10;

	public static void main(String[] args) {
		
		// INITATIZATION PHASE
		Coordonees[] spawnListPlayer1 = new Coordonees[6];
		spawnListPlayer1[0] = new Coordonees(0, 0);
		spawnListPlayer1[1] = new Coordonees(1, 2);
		spawnListPlayer1[2] = new Coordonees(3, 2);
		spawnListPlayer1[3] = new Coordonees(4, 2);
		spawnListPlayer1[4] = new Coordonees(6, 2);
		spawnListPlayer1[5] = new Coordonees(7, 0);
		
		Coordonees[] spawnListPlayer2 = new Coordonees[6];
		spawnListPlayer2[0] = new Coordonees(0, 9);
		spawnListPlayer2[1] = new Coordonees(1, 7);
		spawnListPlayer2[2] = new Coordonees(3, 7);
		spawnListPlayer2[3] = new Coordonees(4, 7);
		spawnListPlayer2[4] = new Coordonees(6, 7);
		spawnListPlayer2[5] = new Coordonees(7, 9);
		
		BoardGame board = new BoardGame(BOARD_SIZE_H, BOARD_SIZE_W, spawnListPlayer1, spawnListPlayer2);
		
		board.displayBoard();
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		// Ajout des totems pour la fin de game
		Totem totemp1 = new Totem(6, 1);
		Totem totemp2 = new Totem(6, 1);
		
		// Ajout des chronomètres
     	Timer chronoplayer1 = new Timer();
     	Timer chronoplayer2 = new Timer();
		
		List<Hero> heros = new ArrayList<Hero>();
		Hero h1 = new Hero("yellow1",2,2,3,120);// TODO : set real stats
		heros.add(h1);
		Hero h2 = new Hero("yellow2",2,2,3,120);
		heros.add(h2);
		Hero h3 = new Hero("blue1",2,2,3,120);
		heros.add(h3);
		Hero h4 = new Hero("blue2",2,2,3,120);
		heros.add(h4);
		Hero h5 = new Hero("red1",2,2,3,120);
		heros.add(h5);
		Hero h6 = new Hero("red2",2,2,3,120);
		heros.add(h6);
		Hero h7 = new Hero("green1",2,2,3,120);
		heros.add(h7);
		Hero h8 = new Hero("green2",2,2,3,120);
		heros.add(h8);
		
		
		//Montrer les héros disponibles avant de choisir
		do {
			pickHeros(p1, heros);
			pickHeros(p2, heros);
		} while(!heros.isEmpty());
     	// Si true retourne false, si false retourne true. True = p1, False = p2
		
		//Game phase
		//Position des héros doit etre : 1-1, 2-3, 4-3, 5-3, 7-3, 8-1   et   1-10, 2-8, 4-8, 5-8, 7-8, 8-10
		
		// lancement de la partie, le joueur1 a son chrono qui se lance
     	// chronomètre pour chaque joueur

		System.out.println("Le joueur 1 commence");
     		chronoplayer1.schedule(new Chrono(), 1000, 1000);
 
     	//les chronomètres changent à chaque fois qu'un des joueurs stop le sien
     	
     	/*do{
        	chronoplayer1.schedule(new Chrono(), 1000, 1000);
         	} while (chronoplayer2.run());
    	
     	do{
    	chronoplayer2.schedule(new Chrono(), 1000, 1000);
     	} while (chronoplayer1.run());*/
    	
		
		while(isFinish()||p1.isDead()||p2.isDead())
		{
			// while chronoplayer1 = 0 -> p1.isDead(), while chronoplayer2 = 0 -> p2.isDead(),
		}
		
	}

	private static boolean isFinish() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	// Vérification sortie de terrain
	public void DéplacementMax(int l, int c) {
		l = l-1;
		c = c-1;
		// savoir si on dépasse du terrain
		if (l<0 || c<0 || l>BOARD_SIZE_H || c>BOARD_SIZE_W) {
			System.out.println("Hors map !");
			return;
		}
	}
	
	// Lancer le chronomètre pour chaque joueur
	
	// Lancer le dés
	private static int diceRoll() {
		
		int resultat;
		
		Random random = new Random();
		
		resultat = random.nextInt(6)+1;
		
		switch(resultat) {
		case 1: /* if(resultat == 1) */
			return 1;
		case 2: /* if(resultat == 2) */
			return 1;
		case 3: /* if(resultat == 3) */
			return 2;
		case 4: /* if(resultat == 4) */
			return 1000;
		case 5: /* if(resultat == 5) */
			return -100;
		case 6: /* if(resultat == 6) */
			return 0;
		default:
			return 0;
		}
		
	}
	
	private static void displayHeroList(List<Hero> heros) {
		for (Hero hero : heros) {
			System.out.println(hero.toString());
		}
	}
	
	private static void pickHeros(Player p, List<Hero> availableHeroList) {
		boolean isInputIncorrect = true;
		do {
			System.out.println("Choisissez les héros parmis la liste suivante : ");
			displayHeroList(availableHeroList);
			
			System.out.println("Tapez le nom du héros choisis : ");
			Scanner sc = new Scanner(System.in);
			String choix = sc.nextLine();
			for (Hero hero : availableHeroList) {
				if(hero.getColor().equalsIgnoreCase(choix)) {
					p.getPlayerhero().add(hero);
					System.out.println("Le héro : "+ hero.toString() +" a été ajouté au joueur " + p.toString() );
					availableHeroList.remove(hero);
					isInputIncorrect = false;
					break;
				}
			}
		} while(isInputIncorrect);

		p.showHeroList();
	}
}
