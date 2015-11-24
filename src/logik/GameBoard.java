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
		int n = 0;
		
		while(n<2){ // Abbruchkriterium: Bis einer gewonnen hat. (testweise zwei Runden)
			// Pro Runde wird folgender Code ausgeführt:
			for(int i = 0; i < 4; i++){
				player[i].getPlayerMove(getPossibilities(player[i]));
				boardUpdate();
			}	
			n++;
		}	
	}
	
	
	// Platz für Hilfmsmethoden
	
	private void boardUpdate(){
		// -> Sollte Spielbrettanzeige Updaten
		
	}
	
	private int[][] getPossibilities(Player player){
		// Guckt sich die Lage des jeweiligen Spielers an 
		// und schlägt dann vernünftige Vorschläge vor
		
//		int token1, token2, token3, token4;		// Gesuchte Spielsteine initilaisieren
//		switch(player.getId()){
//		case 1: token1 = 11; token2 = 12; token3 = 13; token4 = 14; break;
//		case 2: token1 = 21; token2 = 22; token3 = 23; token4 = 24; break;
//		case 3: token1 = 31; token2 = 32; token3 = 33; token4 = 34; break;
//		case 4: token1 = 41; token2 = 42; token3 = 43; token4 = 44; break;
//		default: System.out.println("Error im Switch");
//		}
		
		int checkVar = player.getId()*10+1;
		while(checkVar< player.getId()*10+5){
			for(int i = 0; i < 56; i++){
				if(board[i] == checkVar){
					//gefunden
					
				}
				
			}
			checkVar++;
		}
		
		
		
		
		
		
		return null;
		
	}
	
}
