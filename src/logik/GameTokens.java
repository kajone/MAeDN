package logik;


public class GameTokens {

	private Token[] tokenArray = new Token[16];
	
	
	public GameTokens(Player[] player){
		
		// 16 Spielsteine erstellen und im tokenArray abspeichern
		for(int i = 1; i < 5; i++){
			for(int j = 1; j < 5; j++){
				tokenArray[(i-1)*4+j-1] = new Token((i)*10+j, player[i-1].getColor());
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
	
	// Getter fuer ein Token
	public Token getToken(int i){
		return tokenArray[i];
	}
	public Token[] getAllTokens(int id){
		Token[] playerTokens = new Token[4];
		for (int i = 0; i < 4; i++) {
			playerTokens[i] = tokenArray[4*id+i];
		}
		return playerTokens;
	}

	
}
