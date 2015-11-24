package logik;

public class GameBoard {

	private int[] board = new int[40];	// Legt Spielbrett mit 40 Feldern an
	
	private Player[] player = new Player[4];									

	
										
	public GameBoard(Player[] player){					 					
		
										// Init board: Jedes Feld hat den Wert 0
		for(int i = 0; i < 40; i++)board[i]=0; 
										// Init Player[] 
		this.player = player;
	}
	
	
	
	public void play(){					// Hauptmethode zum spielen
		
		
	}
	
	
	// Platz für Hilfmsmethoden
	
	
}
