package logik;

import java.util.ArrayList;

public class GameBoard {
//	Diese Klasse zieht sich die Positionen der Tokens aus der GameTokens Klasse und kann sie vernünftig darstellen
//	Gespeichert werden informationen jedoch zu keiner Zeit: Die Informationen liegen immer in den einzelenen Spielsteinen

	private Player[] player = new Player[4]; // Verwaltet die 4 teilnehmenden Spieler		
	private GameTokens gameTokens;
	
	
	public GameBoard(Player[] player){
								// Init Player[] 
		this.player = player;
		
		this.gameTokens = new GameTokens(player);
		
	}
									// Hauptmethode zum spielen
     	public void play(){		
     		
     	System.out.println("Willkommen zu Mensch Aerger Dich Nicht!");
     	boardViewUpdate();
     	
     	int n = 0;
		while(n<5){ // Abbruchkriterium: Bis einer gewonnen hat. 
					// (testweise zwei Runden)
			// Pro Runde wird folgender Code ausgefuehrt:
			for(int i = 0; i < player.length; i++){
				
				System.out.println("Spieler " + player[i].getId() + " " + player[i].getName() + " ist an der Reihe");
				// ZUG: besteht aus würfeln, Ergebnisse vorschlagen, Ergebnis auswählen, Ergebnis ausführen, (nochmal würfeln)
				int rollResult = player[i].getRollResult(); 				
				ArrayList<Token> listedPossibilities = gameTokens.checkPossibilities(rollResult);
				Token choosenTurn = player[i].getPlayerDecision(listedPossibilities);
				gameTokens.executePossibility(choosenTurn);
				
				
			}	
			n++;
		}	
		
	}
	// Platz fuer Hilfmsmethoden
     	
     	
    	private boolean rollDice3Times(Player player) {
		System.out.println("Du darfst 3 Mal wuerfeln:");
		for(int i = 0; i < 3; i++){
			if(player.getRollResult() == 6){
				return true;
			}
		}
		return false;
	}
    
    	
    	public void boardViewUpdate(){
    	// Malt Ausgabe neu, zieht sich alle Daten neu	
    		
    		String ausgabe = "";
    		for(int i = 0; i < 11; i++){
    			for(int j = 0; j < 11; j++){
    				if(i < 4 && j < 4){ausgabe += " ";}
    				else if(i < 4 && j > 6){ausgabe += " ";}
    				else if(i > 6 && j < 4){ausgabe += " ";}
    				else if(i > 6 && j > 6){ausgabe += " ";}
    				else if(i == 5 && j == 5){ausgabe += " ";}
    				else if(( i > 0 && i < 5)  && j == 5 || ( i > 5 && i < 10 )  && j == 5){ausgabe += "x";}
    				else if(( j > 0 && j < 5)  && i == 5 || ( j > 5 && j < 10 )  && i == 5){ausgabe += "x";}
    				else{ausgabe += "o";}
    			}
    			ausgabe += "\n";
    		}
    		  			
    		System.out.println(gameTokens.toString());
    	
    	}
}



//	public void boardViewUpdate(){
//		Token[] tempTokens;
//		for(int i = 0; i < 40; i ++){
//			board[i] = null;
//		}
//		for(int i = 0; i < 4; i++){
//			tempTokens=player[i].getTokens();
//			for(int j = 0; j < 4; j++){
//				if(tempTokens[j].getPosition() != -1){
//					board[tempTokens[j].getPosition()] = tempTokens[j];
//				}
//			}
//		}
//				
//		// -> Sollte Spielbrettanzeige Updaten
//		System.out.println("Spielbrett update");
//		// fungiert zu Testzwecken erstmal als toString
//		String ausgabe = "";
//		for(int i = 0; i < 11; i++){
//			for(int j = 0; j < 11; j++){
//				if(i < 4 && j < 4){ausgabe += " ";}
//				else if(i < 4 && j > 6){ausgabe += " ";}
//				else if(i > 6 && j < 4){ausgabe += " ";}
//				else if(i > 6 && j > 6){ausgabe += " ";}
//				else if(i == 5 && j == 5){ausgabe += " ";}
//				else if(( i > 0 && i < 5)  && j == 5 || ( i > 5 && i < 10 )  && j == 5){ausgabe += "x";}
//				else if(( j > 0 && j < 5)  && i == 5 || ( j > 5 && j < 10 )  && i == 5){ausgabe += "x";}
//				else{ausgabe += "p";}
//			}
//			ausgabe += "\n";
//		}
//		int[] positionArray = {18,19,20,17,21,16,22,15,23,10,11,12,13,14,24,25,26,27,28,9,29,8,7,6,5,4,34,33,32,31,30,3,35,2,36,1,37,0,39,38};
//		int oCounter = 0;
//		for(int i = 0; i < ausgabe.length(); i++){
//			if(ausgabe.charAt(i) == 'p'){
//				ausgabe = ausgabe.replaceFirst("p", printArrayElement(positionArray[oCounter]));
//				oCounter++;
//			}
//		}
//		System.out.println(ausgabe);
//	}
//	
//	private String printArrayElement(int position){
//		if(board[position] == null) return "o";
//		else{
//
//			return board[position].getColor().charAt(0) + "";
//		}
//	}
//	
//	private int[] getPossibilities(Player player, int rollResult){
//		// schlaegt alle vernuenftigen Vorschlaege vor
//		
//		// geht fuer jeden Token des Players die Moeglichkeiten durch
//		// bei einer 6 muss sich die Methode nach dem gegeangenen Zug nochmal aufrufen
//		
//		int[] returnPossibilities = new int[5];
//		if(rollResult == 6)returnPossibilities[4] = 1;
//		// Aeusseres If kuemmern sich um Zugzwang
//		
//		// Wenn das erste Feld durch einen Spielstein der eigenen Farbe belegt ist gilt Zugzwang das Feld zu rï¿½umen
//		try{
//			if(board[0].getId()/10 == player.getId()){
//				for(int i = 0; i < 4; i++){
//					if(i == board[0].getId()-(player.getId()*10)-1){
//						System.out.println("ZUGZWANG: Feld raeumen, Spielstein " + board[0].getId() + " auf " + rollResult);
//						returnPossibilities[board[0].getId()-(player.getId()*10)-1] =  rollResult;
//					}
//					else{
//						returnPossibilities[i] = -1;
//					}
//				}	
//			}
//		}catch(NullPointerException e){
//			for(int i = 0; i < 4; i ++){
//				// Spezialfall: Spielstein steht im Haus und es wurde keine 6 gewï¿½rfelt
//				if(player.getTokens()[i].getPosition() == -1 && rollResult != 6){
//					System.out.println("Spezialfall: Spielstein steht im Haus und es wurde keine 6 gewï¿½rfelt");
//					returnPossibilities[i] = -1;
//				// Spezialfall: Spielstein steht im Haus und es wird eine 6 gewï¿½rfelt
//
//				}else if(player.getTokens()[i].getPosition() == -1 && rollResult == 6){
//					System.out.println("Spezialfall: Spielstein steht im Haus und es wird eine 6 gewï¿½rfelt");
//					// Spieler setzt Spielstein auf erstes Feld
//					returnPossibilities[i] = player.getTokens()[i].getPosition() + 1;
//					// Spieler ist jetzt nochmal dran
//				}
//				
//				else{
//				
//				// Normalfall, Spielstein steht auf dem Spielfeld und kann normal bewegt werden
//				returnPossibilities[i] = player.getTokens()[i].getPosition() + rollResult;	
//				}
//			}
//		}
//		
//
//		
//
//		return returnPossibilities;		
//	}
//	
//
//	
//	private boolean checkStartPosition(Player player){
//		boolean checkStart = true;
//		for(int i = 0; i < 4; i++){
//			if(!(player.getTokens()[i].getPosition() == -1)){
//				checkStart = false;
//			}
//		}
//		if(checkStart){
//			System.out.println("Du hast alle Kollegen auf der Startposition!");
//		}
//		
//		return checkStart;
//	}
//	

//	private void kickToken(Token t1, Token t2){
//		int tmp;
//		tmp = t2.getPosition();
//		t1.setPosistion(tmp);
//		t2.setPosistion(-1);
//	}
//	private void colisionCheck(Token t, int diceRoll){
//		for (int i = 0; i < 4; i++) {
//			Player p = player[i];
//			Token [] tokens =p.getTokens();
//			for (int j = 0; j < 16; j++) {
//				Token t2 = tokens[j];
//				if(t.getPosition() + diceRoll == t2.getPosition())
//					colorCheck(t, t2);
//			}
//		}
//	}
//	private void colorCheck(Token t1, Token t2 ){
//		boolean colorcheck = false;
//		if(t1.getColor() == t2.getColor())
//			kickToken(t1,t2);
//		else{
//			System.out.println("Zug nicht moeglich. Waehle anderen Spielstein");
//			
//		} 
//			
//	}
//	public String printBoard(){
//		String s = "";
//		for(int i = 0; i < playBoard.length; i++){
//			for(int j = 0; j < playBoard[0].length; j++){
//				s+=playBoard[i][j];
//			}
//			s+="\n";
//		}
//		return s;
//	}
//	public void mergeBoards(){
//		for(int i = 0; i < playBoard.length; i++){
//			for(int j = 0; j < playBoard[0].length; j++){
//				if(playBoard[i][j] == 'o');
//					
//			}
//		}
//	}
//}



/* 
 * 
 *
 * 
 * //	private File boardFile;
 * 
 * //		this.boardFile = f;
//		this.playBoard = new char[11][11];
//		try (Scanner sc = new Scanner(boardFile)) {
//			while (sc.hasNext()) {
//				for (int i = 0; i < 11; i++) {
//					playBoard[i] = sc.nextLine().toCharArray();
//
//				}
//			}
//		}catch (FileNotFoundException e){
//			System.out.println(e.getMessage());
//		}
//
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

