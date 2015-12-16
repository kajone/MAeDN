package logik;

import java.util.Random;

import server.ConnectedClient;

public class BotPlayer implements Player{
	private int id;
	private String name;
	private String color;
	
	public BotPlayer(String name, String color, int id){
		this.name = name;
		this.color = color;
		this.id = id;
	}
	
	public ConnectedClient getClient() {
		return null;
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
	
	public String toString(){
		String s = "";
		s += "Spieler " + this.name + " mit der Farbe " + this.color + " Player " + this.id ; 
		return s;
	}
	
	public int getPlayerDecision(int intMax) {
		Random turn = new Random();
		return turn.nextInt(intMax);
	}

}