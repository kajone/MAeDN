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
	
	public int getPlayerDecision(Server server, int intMax){
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while(true){
			try{
				input = Integer.parseInt(sc.nextLine());
				if((input >= 0 && input < intMax )){
					break;
				}
				server.writeToClient("Gib besser eine Zahl zwischen 0 und " + (intMax-1) + " ein", getClient().getSessionId());
			}
			catch(NumberFormatException e){
				server.writeToClient("Gib besser eine Zahl zwischen 0 und " + (intMax-1) + " ein", getClient().getSessionId());
			}
		}
		client.writeMessage(input+"");
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
		sc.nextLine();
		Random randomize = new Random();
		int rollResult = (randomize.nextInt(6)+1);
		client.writeMessage(rollResult+"");
		return rollResult;
	}
}