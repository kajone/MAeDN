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
     	System.out.println("Willkommen zu Mensch Aerger Dich Nicht!");
     	boardViewUpdate();
     	int n = 0;
		while(n<5){ // Abbruchkriterium: Bis einer gewonnen hat. 
					// (testweise zwei Runden)
			// Pro Runde wird folgender Code ausgefuehrt:
			for(int i = 0; i < 4; i++){
				
				System.out.println("Spieler " + player[i].getId() + " " 
						+ player[i].getName() + " ist an der Reihe");
				int rollResult=0;
				if(checkStartPosition(player[i])){
					if(!rollDice3Times()) continue;
					else rollResult = 6;	
				}
				
				while(true){
					if(rollResult == 0) rollResult = getRollResult();
					if(!player[i].getPlayerMove(getPossibilities(player[i],rollResult))) break;
					boardViewUpdate();
					rollResult = getRollResult();
				
					
				}
				boardViewUpdate();
			}	
			n++;
		}	
		
	}
	// Platz fuer Hilfmsmethoden
	


	public void boardViewUpdate(){
		Token[] tempTokens;
		for(int i = 0; i < 40; i ++){
			board[i] = null;
		}
		for(int i = 0; i < 4; i++){
			tempTokens=player[i].getTokens();
			for(int j = 0; j < 4; j++){
				if(tempTokens[j].getPosition() != -1){
					board[tempTokens[j].getPosition()] = tempTokens[j];
				}
			}
		}
				
		// -> Sollte Spielbrettanzeige Updaten
		System.out.println("Spielbrett update");
		// fungiert zu Testzwecken erstmal als toString
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
				else{ausgabe += "p";}
			}
			ausgabe += "\n";
		}
		int[] positionArray = {18,19,20,17,21,16,22,15,23,10,11,12,13,14,24,25,26,27,28,9,29,8,7,6,5,4,34,33,32,31,30,3,35,2,36,1,37,0,39,38};
		int oCounter = 0;
		for(int i = 0; i < ausgabe.length(); i++){
			if(ausgabe.charAt(i) == 'p'){
				ausgabe = ausgabe.replaceFirst("p", printArrayElement(positionArray[oCounter]));
				oCounter++;
			}
		}
		System.out.println(ausgabe);
	}
	
	private String printArrayElement(int position){
		if(board[position] == null) return "o";
		else{

			return board[position].getColor().charAt(0) + "";
		}
	}
	
	private int[] getPossibilities(Player player, int rollResult){
		// schlaegt alle vernuenftigen Vorschlaege vor
		
		// geht fuer jeden Token des Players die Moeglichkeiten durch
		// bei einer 6 muss sich die Methode nach dem gegeangenen Zug nochmal aufrufen
		
		int[] returnPossibilities = new int[5];
		if(rollResult == 6)returnPossibilities[4] = 1;
		// Aeusseres If kuemmern sich um Zugzwang
		
		// Wenn das erste Feld durch einen Spielstein der eigenen Farbe belegt ist gilt Zugzwang das Feld zu räumen
		try{
			if(board[0].getId()/10 == player.getId()){
				for(int i = 0; i < 4; i++){
					if(i == board[0].getId()-(player.getId()*10)-1){
						System.out.println("ZUGZWANG: Feld raeumen, Spielstein " + board[0].getId() + " auf " + rollResult);
						returnPossibilities[board[0].getId()-(player.getId()*10)-1] =  rollResult;
					}
					else{
						returnPossibilities[i] = -1;
					}
				}	
			}
		}catch(NullPointerException e){
			for(int i = 0; i < 4; i ++){
				// Spezialfall: Spielstein steht im Haus und es wurde keine 6 gewürfelt
				if(player.getTokens()[i].getPosition() == -1 && rollResult != 6){
					System.out.println("Spezialfall: Spielstein steht im Haus und es wurde keine 6 gewürfelt");
					returnPossibilities[i] = -1;
				// Spezialfall: Spielstein steht im Haus und es wird eine 6 gewürfelt

				}else if(player.getTokens()[i].getPosition() == -1 && rollResult == 6){
					System.out.println("Spezialfall: Spielstein steht im Haus und es wird eine 6 gewürfelt");
					// Spieler setzt Spielstein auf erstes Feld
					returnPossibilities[i] = player.getTokens()[i].getPosition() + 1;
					// Spieler ist jetzt nochmal dran
				}
				
				else{
				
				// Normalfall, Spielstein steht auf dem Spielfeld und kann normal bewegt werden
				returnPossibilities[i] = player.getTokens()[i].getPosition() + rollResult;	
				}
			}
		}
		

		

		return returnPossibilities;		
	}
	
	private int getRollResult(){
		
		Random randomize = new Random();
		int rollResult = (randomize.nextInt(6)+1);
		System.out.println("Du hast eine " + rollResult + " gewuerfelt!");
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
			System.out.println("Du hast alle Kollegen auf der Startposition!");
		}
		
		return checkStart;
	}
	
	private boolean rollDice3Times() {
		System.out.println("Du darfst 3 Mal wuerfeln:");
		for(int i = 0; i < 3; i++){
			if(getRollResult() == 6){
				return true;
			}
		}
		return false;
	}
}
