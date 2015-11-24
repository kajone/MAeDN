package logik;

public class RealPlayer implements Player{
	private int id;
	private String name;
	private String color;
	
	
	public RealPlayer(String name, String color, int id){
		this.name = name;
		this.color = color;
		this.id = id;
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
	
	
	@Override
	public int[] getPlayerMove(int[][] possibilities) {
		// TODO Auto-generated method stub
		return null;
	}



}
