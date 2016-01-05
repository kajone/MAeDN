package logik;

import java.util.LinkedList;

import server.Server;

public class MainClass {
	
	public MainClass(Server server, Player[] player){
		play(server, player);
	}

	public void play(Server server, Player[] player) {
		// Initialisiert ein Spiel mit so vielen RealPlayern wie Clients angemeldet sind
		String welcome = "Willkommen bei Mensch aerger dich nicht!\n Es wird mit " +  
				  server.getConnectedClients().size() + " echten Spielern und " + 
				  (4-server.getConnectedClients().size()) + " Computer-Spielern gespielt:\n";
		for(int i = 0; i < player.length; i++) welcome += player[i].toString() + "\n"; 
		server.writeToAll(welcome);
		GameBoard mainBoard = new GameBoard(player);		
		boolean checkWin = false;
		String turnBegin = null;
		while (!checkWin) {
			int roll;
			round: for (int i = 0; i < 4; i++) {
				turnBegin = player[i].getName() + " ist dran! (Player "+ player[i].getId() + ")\n" + mainBoard.toString();
				server.writeToAll(turnBegin);
				if (mainBoard.threeTimeRoll(i)) {			  //unnormaler Zug: 3 Mal wuerfeln
					if(player[i] instanceof RealPlayer)server.writeToClient("Du darfst 3 mal wuerfeln, " + player[i].getName()+".", player[i].getClient().getSessionId());
					for (int j = 0; j < 3; j++) {
						roll = player[i].getRollResult(server); //PLAYER wuerfelt
						if (roll == 6) {
							if(player[i] instanceof RealPlayer)server.writeToClient("Du hast eine 6 gewuerfelt. Damit darfst du raus!", player[i].getClient().getSessionId());
							if(!performTurn(server, mainBoard, i, roll, player)) continue;  //Der nächste ist dran Wenn kein Zug moeglich ist
							int win = mainBoard.checkWin();
							if(win != 0){
								checkWin=true;
								server.writeToAll(player[win].getName()+ " hat gewonnen!\n"+mainBoard.toString());
								break round;
							}
							if(player[i] instanceof RealPlayer)server.writeToClient("Du bist nochmal dran!", player[i].getClient().getSessionId());
							i -= 1;
							break;
						} else{
							if(player[i] instanceof RealPlayer)server.writeToClient("Du hast eine " + roll + " gewuerfelt. Versuchs nochmal! " 
												 +(j+1) + "/3", player[i].getClient().getSessionId());
						}
					}
				} else {							// normaler Zug
					roll = player[i].getRollResult(server);      //PLAYER wuerfelt
					if(player[i] instanceof RealPlayer)server.writeToClient("Du hast eine " + roll + " gewuerfelt!", player[i].getClient().getSessionId());
					if(!performTurn(server, mainBoard, i, roll, player)) continue; // Wenn kein Zug moeglich ist
					int win = mainBoard.checkWin();
					if(win != 0){
						checkWin=true;
						server.writeToAll(player[win].getName()+ " hat gewonnen!\n"+mainBoard.toString());
						break;
					}
					if (roll == 6) {
						if(player[i] instanceof RealPlayer)server.writeToClient("Du bist nochmal dran!", player[i].getClient().getSessionId());
						i -= 1;
					}
				}
			}
		}
	}

	
	private boolean performTurn(Server server, GameBoard mainBoard, int playerId, int roll, Player[] player){
		LinkedList<Token> possibilities = mainBoard.getAllMoves(playerId, roll);
		String possibilitiyString = ""; 
		for (Token t : possibilities) {
			possibilitiyString += t.getId()+ " ";
		}
		possibilitiyString = "Du hast folgende Moeglichkeiten:\n "+ possibilitiyString;
		if(player[playerId] instanceof RealPlayer)server.writeToClient(possibilitiyString, player[playerId].getClient().getSessionId());
		if(possibilities.size() == 0){
			if(player[playerId] instanceof RealPlayer)server.writeToClient("Du hast Keine Zugmöglichkeiten, der naechste ist dran!", player[playerId].getClient().getSessionId());
			return false;
		}
		int choose = player[playerId].getPlayerDecision(server, possibilities.size());		//PLAYER entscheidet
		Token t = possibilities.get(choose);
		mainBoard.move(t, mainBoard.moveToken(t, roll));
		if(player[playerId] instanceof RealPlayer)server.writeToClient("--------------------------", player[playerId].getClient().getSessionId());
		return true;
	}	
}