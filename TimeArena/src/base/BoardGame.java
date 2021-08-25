package base;

import tools.Coordonees;

public class BoardGame {
	private int dimX;
	private int dimY;
	private Hero[][] board;
	private Coordonees[] spawnListPlayer1;
	private Coordonees[] spawnListPlayer2;
	
	public void displayBoard() {
		
		for(int y=0; y<dimY ; y++) {
			System.out.println("________________________________________________");
			
			for(int x=0; x<dimX ; x++) {
				System.out.print("|");
				if(board[x][y]==null) {
					if(isSpawn(x, y)) {
						System.out.print("  O  ");
					} else {
						System.out.print("     ");
					}
				} else {
					System.out.print("  H  ");
				}
			}
			System.out.println("|");
		}
		System.out.println("________________________________________________");	
	}

	private boolean isSpawn(int x, int y) {
		for (Coordonees coor: spawnListPlayer1) {
			if (x==coor.getX() && y==coor.getY())
				return true;
		}
		for (Coordonees coor: spawnListPlayer2) {
			if (x==coor.getX() && y==coor.getY())
				return true;
		}
		return false;
	}

	public BoardGame(int dimX, int dimY, Coordonees[] spawnListPlayer1, Coordonees[] spawnListPlayer2) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.board = new Hero[dimX][dimY];
		this.spawnListPlayer1 = spawnListPlayer1;
		this.spawnListPlayer2 = spawnListPlayer2;
	}
	
}
