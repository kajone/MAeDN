package logik;

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
	
	@Override
	public int[] getPlayerMove(int[][] possibilities) {
		// TODO Auto-generated method stub
		return null;
	}



}
