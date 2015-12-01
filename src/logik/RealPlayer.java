package logik;

import java.util.ArrayList;

public class RealPlayer implements Player{
	private int id;
	private String name;
	private String color;
	private Token[] tokens;
	
	public RealPlayer(String name, String color, int id){
		this.name = name;
		this.color = color;
		this.id = id;
		
		tokens = new Token[4];
		
		for(int i = 0; i < 4; i++){
			tokens[i] = new Token(id*10+1+i, color);
		}
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}

	public int getId() {
		return id;
	}
	
	public Token[] getTokens(){
		return tokens;
	}
	
	
	public Token getPlayerDecision(ArrayList<Token> listedPossibilities) {
		//tokens[0].setPosistion(5);
//		String s = "Array mit allen Moeglichkeiten: ";
//		for(int i = 0; i< 4; i++){
//			s += possibilities[i] + " ";			
//		}
//		System.out.println(s);
//		
//		boolean isItYourTurnAgain = false;
//		if(possibilities[4] == 1){
//			isItYourTurnAgain = true;
//		}
//		
//		
//		for(int i = 0; i < 4; i++){
//			if(possibilities[i] != -1){
//				tokens[i].setPosistion(possibilities[i]);
//				break;
//			}
//		}
		return null;
	}


	@Override
	public int getRollResult() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
