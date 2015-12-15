package logik;

import java.util.Random;

public class BotPlayer implements Player{
	private int id;
	private String name;
	private String color;
	
	public BotPlayer(String name, String color, int id){
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
	

	public int getRollResult(){
		Random randomize = new Random();
		int rollResult = (randomize.nextInt(6)+1);
		return rollResult;
	}
	
	public int getPlayerDecision(int intMax) {
		Random turn = new Random();
		return turn.nextInt(intMax);
	}

}

