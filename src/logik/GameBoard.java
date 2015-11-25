package logik;

import java.util.Random;

public class GameBoard {

	private Token[] board = new Token[40];	// Legt Spielbrett mit 40 Feldern an
	private Token[][] home = new Token[4][4]; // Sorgt sich um die Zielhaeuschen
	private Player[] player = new Player[4]; // Verwaltet die 4 teilnehmenden Spieler									

										
	public GameBoard(Player[] player){					 					
		
										// Init board: Jedes Feld hat den Wert 0
		for(int i = 0; i < 40; i++)board[i]=null; 
										// Init home: Jedes Hausfeld Wert 0
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				home[i][j] = null;
			}
		}
		
										// Init Player[] 
		this.player = player;	
	}
	
     	public void play(){				// Hauptmethode zum spielen
		int n = 0;
		
		while(n<2){ // Abbruchkriterium: Bis einer gewonnen hat. 
					// (testweise zwei Runden)
			// Pro Runde wird folgender Code ausgefuehrt:
			for(int i = 0; i < 4; i++){
				
				System.out.println("Spieler " + player[i].getId() + " " 
						+ player[i].getName() + " ist an der Reihe");
				
				player[i].getPlayerMove(getPossibilities(player[i],
						getRollResult()));
				boardUpdate();
			}	
			n++;
		}	
	}
	// Platz fuer Hilfmsmethoden
	
	private void boardUpdate(){
		// -> Sollte Spielbrettanzeige Updaten
		System.out.println("Spielbrett update");
		// fungiert zu Testzwecken erstmal als toString
		
	}
	
	private int[][] getPossibilities(Player player, int rollResult){
		// braucht Wuerfelergebnis
		// schlaegt vernuenftige Vorschlaege vor
		


		return null;		
	}
	
	private int getRollResult(){
		
		Random randomize = new Random();
		int rollResult = (randomize.nextInt(5)+1);
		System.out.println("Es wird eine " + rollResult + " gewuerfelt!");
		return rollResult;
	}
	
	private boolean checkStartPosition(Player player){
		boolean checkStart = true;
		for(int i = 0; i < 4; i++){
			if(!(player.getTokens()[i].getPosition() == -1)){
				checkStart = false;
			}
		}
		if(checkStart){
			System.out.println("Du hast alle Kollegen am Start!");
		}
		
		return checkStart;
	}
}
