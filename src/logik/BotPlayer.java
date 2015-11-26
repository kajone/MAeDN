package logik;

public class BotPlayer implements Player{
	private int id;
	private String name;
	private String color;
	private Token[] tokens;
	
	public BotPlayer(String name, String color, int id){
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

	
	public boolean getPlayerMove(int[] possibilities) {
		//tokens[0].setPosistion(8);
		String s = "Array mit allen Moeglichkeiten: ";
		for(int i = 0; i< 4; i++){
			s += possibilities[i] + " ";			
		}
		System.out.println(s);
		
		boolean isItYourTurnAgain = false;
		if(possibilities[4] == 1){
			isItYourTurnAgain = true;
		}
		
		
		for(int i = 0; i < 4; i++){
			if(possibilities[i] != -1){
				tokens[i].setPosistion(possibilities[i]);
				break;
			}
		}
		return isItYourTurnAgain;
	}

}

