package logik;

public class BotPlayer implements Player{

	private String name;
	private String color;
	
	
	public BotPlayer(String name, String color){
		this.name = name;
		this.color = color;
			
	}
	
	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	@Override
	public int[] getPlayerMove(int[][] possibilities) {
		// TODO Auto-generated method stub
		return null;
	}

}
