package logik;

public class RealPlayer implements Player{
	private String name;
	private String color;
	
	
	public RealPlayer(String name, String color){
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
