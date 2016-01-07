package logik;

import java.util.Random;

import server.ConnectedClient;
import server.Server;

public class BotPlayer implements Player{
	private int id;
	private String name;
	private String color;
	
	public BotPlayer(String name, String color){
		this.name = name;
		this.color = color;
		switch(color){
		case "gelb": this.id = 1; break;
		case "gruen": this.id = 2; break;
		case "rot": this.id = 3; break;
		case "schwarz": this.id = 4; break;
		default: break;
		}
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
	
	public int getRollResult(Server server){
		Random randomize = new Random();
		int rollResult = (randomize.nextInt(6)+1);
		return rollResult;
	}
	
	public String toString(){
		String s = "";
		s += "Spieler " + this.name + " mit der Farbe " + this.color + " Player " + this.id ; 
		return s;
	}
	
	public int getPlayerDecision(Server server, int intMax) {
		Random turn = new Random();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return turn.nextInt(intMax);
	}

}