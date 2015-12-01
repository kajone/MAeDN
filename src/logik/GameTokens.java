package logik;

import java.util.ArrayList;

public class GameTokens {

	private Token[] tokenArray = new Token[16];
	
	
	public GameTokens(Player[] player){
		
		// 16 Spielsteine erstellen und im tokenArray abspeichern
		int tokenCounter = 0;
		for(int i = 1; i < 5; i++){
			for(int j = 1; j < 5; j++){
				tokenArray[tokenCounter] = new Token((i)*10+j, player[i-1].getColor());
				tokenCounter++;
			}	
		}	
	}
	
	// Ausgabe der 16 Spielsteine
	public String toString(){
		String s = "";
		for(int i = 0; i < tokenArray.length; i++){
			s += "Spielstein: " + tokenArray[i].getId() + " mit der Farbe " +  
				  tokenArray[i].getColor() + " auf Position " + tokenArray[i].getPosition() + "\n";
		}
		return s;
	}
	
	// Getter für ein Token
	public Token getToken(int i){
		return tokenArray[i];
	}
	
	// Prüft die Möglichekiten für einen Spieler
	public ArrayList<Token> checkPossibilities(int rollResult){
		return null;
	}
	
	// Führt die Entscheidung eines Spielers aus
	public void executePossibility(Token token){
		
	}

	
}
