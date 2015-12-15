package logik;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class GameBoard {
	private GameTokens gTokens;
	private Token[] board;

	public GameBoard(Player[] players) {
		gTokens = new GameTokens(players);
		board = new Token[56];
	}
	
	public void move(Token t, int position){
		if(t.getPosition() != -1){
			board[t.getPosition()] = null;
		}
		if(board[position] != null){
			board[position].setPosistion(-1);
		}
		t.setPosistion(position);
		board[position] = t;
		System.out.println(t.getId()+" move to "+position);
	}

	public int rollDice() {
		return new Random().nextInt(6) + 1;
	}

	public LinkedList<Token> getAllMoves(int playerID, int rollResult) {
		LinkedList<Token> result = new LinkedList<Token>();
		HashMap <Token, Priority> mapping = new HashMap<Token, GameBoard.Priority>(); 
		Token[] tokens = gTokens.getAllTokens(playerID);
		int housePosition = ((playerID + 3) % 4) * 10 + 9;
		for(Token t : tokens){
			int pos = moveToken(t, rollResult);
			if(pos==-2)continue;
			MoveResult moveResult = checkMove(t, pos);
			if(moveResult==MoveResult.OWN || moveResult==MoveResult.HOUSEOVERJUMP){
				mapping.put(t, Priority.BLOCKED);
			}
			else if((housePosition + 1)%40 == t.getPosition()){ //TODO: check haus voll
				mapping.put(t, Priority.MAKEFREE);
				continue;
			}
			else if(pos == (housePosition+1)%40){
				mapping.put(t, Priority.GETOUT);
				continue;
			}
			else if(moveResult==MoveResult.OTHER)
				mapping.put(t, Priority.HIT);
			else if(moveResult==MoveResult.FREE)
				mapping.put(t, Priority.RUN);
		}
		Priority max = Priority.RUN;
		for(Token t : mapping.keySet()){
			result.add(t);
			if(max.compareTo(mapping.get(t)) > 0){
				max = mapping.get(t);
			}
		}
		LinkedList<Token> toDelete = new LinkedList<Token>();
		for(Token t : mapping.keySet()){
			if(max.compareTo(mapping.get(t)) < 0){
				toDelete.add(t);
			}
		}
		result.removeAll(toDelete);
		return result;
	}

	public int moveToken(Token t, int rollResult) {
		int result;
		int currentPosition = t.getPosition();
		int playerNumber = t.getId() / 10 - 1;
		int housePosition = ((playerNumber + 3) % 4) * 10 + 9;
		if(currentPosition == -1){
			if(rollResult == 6){
				return (housePosition+1)%40;
			}
			else 
				return -1;
		}
		int transform = (40 + currentPosition - t.getStart())%40;
		if(t.inHouse()) 
			transform = 40 + currentPosition - t.houseStart();
		int newTokenPosition = (transform + rollResult);
		if (newTokenPosition >= 40) {
			int idHouse = newTokenPosition - 40;
			if(idHouse > 3) return -2;
			result = 40  + idHouse;
		} else {
			result = newTokenPosition;
		}
		if(newTokenPosition >=40) 
			result = 40 + 4 * playerNumber + (newTokenPosition - 40);
		else 
			result = (40 + newTokenPosition + t.getStart())%40;
		return result;
	}

	private enum MoveResult {
		FREE, OWN, OTHER, HOUSEOVERJUMP, STAY
	}
	private enum Priority{
		MAKEFREE, GETOUT, HIT, RUN, BLOCKED
	}

	private MoveResult checkMove(Token t, int newPosition) {
		if(newPosition == -1)return MoveResult.STAY;
		if (board[newPosition] == null) {
			for (int i = newPosition; i > t.getHouseEnd()-4; i--) {
				if(board[i] != null){
					if(board[i].getId() != t.getId()){
						System.out.println(t.getId() + ": Kein Jump im eigenen Haus!");
						return MoveResult.HOUSEOVERJUMP;
					}
				}
			}
			return MoveResult.FREE;
		}
		if (board[newPosition].getPlayerId() == t.getPlayerId()) {
			return MoveResult.OWN;
		}
		return MoveResult.OTHER;
	}
	public boolean threeTimeRoll(int id){
		boolean isOK = true;
		Token[] playerTokens = gTokens.getAllTokens(id);
		for (int i = 0; i < 4; i++) {
			if(playerTokens[i].getPosition() == -1)
				continue;
			if(playerTokens[i].inHouse())
				for (int j = playerTokens[i].getPosition()+1; j <= playerTokens[i].getHouseEnd(); j++) {
					if(board[j]==null){ 
						isOK = false;
						break;
					}
				}
			else 
				isOK = false;
		}
		return isOK;
	}
	
	public String toString(){
		// Eine funktionierende toString Methode, gibt sogar das Haus mit aus
		String ausgabe = "";
		for(int i = 0; i < 11; i++){
 			for(int j = 0; j < 11; j++){
 				if(i < 4 && j < 4){ausgabe += " ";}
 					else if(i < 4 && j > 6){ausgabe += " ";}
 					else if(i > 6 && j < 4){ausgabe += " ";}
 					else if(i > 6 && j > 6){ausgabe += " ";}
 					else if(i == 5 && j == 5){ausgabe += " ";}
 					else if(( i > 0 && i < 5)  && j == 5 || ( i > 5 && i < 10 )  && j == 5){ausgabe += "h";}
 					else if(( j > 0 && j < 5)  && i == 5 || ( j > 5 && j < 10 )  && i == 5){ausgabe += "h";}
 					else{ausgabe += "n";}
 			}	
 			ausgabe += "\n";
		}
		int[] positionArray = {18,19,20,17,21,16,22,15,23,10,11,12,13,14,24,25,26,27,28,9,29,8,7,6,5,4,34,33,32,31,30,3,35,2,36,1,37,0,39,38};
		int[] houseArray = {48,49,50,51,44,45,46,47,55,54,53,52,43,42,41,40};
		int oCounter = 0;
		int hCounter = 0;
		for(int i = 0; i < ausgabe.length(); i++){
			if(ausgabe.charAt(i) == 'n'){
				if(board[positionArray[oCounter]] != null){
					ausgabe = ausgabe.replaceFirst("n", board[positionArray[oCounter]].getColor().charAt(0)+"");
				}
				else{
					ausgabe = ausgabe.replaceFirst("n", "o");
				}
				oCounter++;
			}
			else if(ausgabe.charAt(i) == 'h'){
				if(board[houseArray[hCounter]] != null){
					ausgabe = ausgabe.replaceFirst("h", board[houseArray[hCounter]].getColor().charAt(0)+"");
				}
				else{
					ausgabe = ausgabe.replaceFirst("h", "x");
				}
				hCounter++;
			}	
		}
		return ausgabe;
	}

	public int checkWin() {
		int wincounter=0;
		for(int i = 40; i < 53; i+=4){
			for(int j = i; j < i+4; j++){
				if(board[j] != null){
					wincounter++;
					if(wincounter == 4){
						//Jemand hat gewonnen!
						return board[j].getPlayerId();
					}
				}
			}
			wincounter = 0;
		}
		return 0;
	}
}
