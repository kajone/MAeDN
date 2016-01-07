package logik;

import java.util.Random;
import java.util.Scanner;

import server.ConnectedClient;
import server.Server;

public class RealPlayer implements Player{
	private int id;
	private String name;
	private String color;
	private Token[] tokens;
	private ConnectedClient client;
	
	public RealPlayer(String name, String color, int id, ConnectedClient client){
		this.name = name;
		this.color = color;
		this.id = id;
		this.client = client;
		
		tokens = new Token[4];
		
		for(int i = 0; i < 4; i++){
			tokens[i] = new Token(id*10+1+i, color);
		}
		
	}
	public ConnectedClient getClient() {
		return client;
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
	
	
	public void initRealPlayer(Server server){
		server.writeToClient("[YOU];" + getName(), getClient().getSessionId());
	}
	
	public int getPlayerDecision(Server server, int intMax){
		int input = -1;
		while(true){
			
			try{
				server.writeToClient("Wähle Jetzt!", getClient().getSessionId());
				input = server.waitForDecision();
				if((input >= 0 && input < intMax )){
					break;
				}
				server.writeToClient("Gib besser eine Zahl zwischen 0 und " + (intMax-1) + " ein.", getClient().getSessionId());
			}
			catch(NumberFormatException e){
				server.writeToClient("Gib besser eine Zahl zwischen 0 und " + (intMax-1) + " ein.", getClient().getSessionId());
			}
		}
		return input;
	}
	
	public String toString(){
		String s = "";
		s += "Spieler " + this.name + " mit der Farbe " + this.color + " Player " + this.id ; 
		return s;
	}
	
	public int getRollResult(Server server) {
		Scanner sc = new Scanner(System.in); 
		server.writeToClient("Drücken Sie ENTER um zu würfeln, " + name + ".", getClient().getSessionId());
		// Hier ist jetzt ein Listener, damit er auf ein ENTER vom Client hört und das Würfeln auslösen kann
		server.waitForRollResult();
		Random randomize = new Random();
		int rollResult = (randomize.nextInt(6)+1);
		client.writeMessage("[ERGEBNIS]:" +rollResult);
		return rollResult;
	}
}