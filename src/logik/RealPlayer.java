package logik;

import java.util.Random;
import java.util.Scanner;

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
	
	public int getPlayerDecision(int intMax){
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while(true){
			try{
				input = Integer.parseInt(sc.nextLine());
				if((input >= 0 && input < intMax )){
					break;
				}
				System.out.println("Gib besser eine Zahl zwischen 0 und " + (intMax-1) + " ein");
			}
			catch(NumberFormatException e){
				System.out.println("Gib besser eine Zahl zwischen 0 und " + (intMax-1) + " ein");
			}
		}
		return input;
	}
	
	public int getRollResult() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Drücken Sie ENTER um zu würfeln, " + name + ".");
		sc.nextLine();
		Random randomize = new Random();
		int rollResult = (randomize.nextInt(6)+1);
		return rollResult;
	}
}