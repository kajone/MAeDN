package logik;

import java.util.LinkedList;

import server.Server;

public class MainClass {
	
	public MainClass(Server server, Player[] player){
		play(server, player);
	}

	public void play(Server server, Player[] player) {
		// Initialisiert ein Spiel mit so vielen RealPlayern wie Clients angemeldet sind
		String willkommen = "Willkommen bei Mensch aerger dich nicht!\n Es wird mit " +  
				  server.getConnectedClients().size() + " echten Spielern und " + 
				  (4-server.getConnectedClients().size()) + " Computer-Spielern gespielt:\n";
		for(int i = 0; i < player.length; i++) willkommen += player[i].toString() + "\n"; 
		server.writeToAll(willkommen);
		
		GameBoard mainBoard = new GameBoard(player);		
		boolean checkWin = false;
		while (!checkWin) {
			int roll;
			round: for (int i = 0; i < 4; i++) {
				System.out.println(player[i].getName() + " ist dran! (Player "+ player[i].getId() + ")");
				System.out.println("So sieht das Spielfeld gerade aus: ");
				System.out.println(mainBoard.toString());
				if (mainBoard.threeTimeRoll(i)) {			  //unnormaler Zug: 3 Mal wuerfeln
					System.out.println("Du darfst 3 mal wuerfeln, " + player[i].getName()+".");
					for (int j = 0; j < 3; j++) {
						roll = player[i].getRollResult(); //PLAYER wuerfelt
						if (roll == 6) {
							System.out.println("Du hast eine 6 gewuerfelt. Damit darfst du raus!");
							if(!performTurn(mainBoard, i, roll, player)) continue;  //Der nächste ist dran Wenn kein Zug moeglich ist
							int win = mainBoard.checkWin();
							if(win != 0){
								checkWin=true;
								System.out.println(player[win].getName()+ " hat gewonnen!");
								System.out.println(mainBoard.toString());
								break round;
							}
							System.out.println(player[i].getName() + " ist nochmal dran!");
							i -= 1;
							break;
						} else{
							System.out.println("Du hast eine " + roll
									+ " gewuerfelt. Versuchs nochmal! " + (j+1) + "/3");
						}
					}
				} else {							// normaler Zug
					roll = player[i].getRollResult();      //PLAYER wuerfelt
					System.out.println("Du hast eine " + roll + " gewuerfelt!");
					if(!performTurn(mainBoard, i, roll, player)) continue; // Wenn kein Zug moeglich ist
					int win = mainBoard.checkWin();
					if(win != 0){
						checkWin=true;
						System.out.println(player[win].getName()+ " hat gewonnen!");
						System.out.println(mainBoard.toString());
						break;
					}
					if (roll == 6) {
						System.out.println(player[i].getName() + " ist nochmal dran! (Player "+ player[i].getId() + ")");
						i -= 1;
					}
				}
			}
		}
	}

	
	private boolean performTurn(GameBoard mainBoard, int playerId, int roll, Player[] player){
		LinkedList<Token> possibilities = mainBoard.getAllMoves(playerId, roll);
		for (Token t : possibilities) {
			//s.writeToClient(t.getId() + "", player[playerId].getClient().getSessionId());
			System.out.println();
		}
		if(possibilities.size() == 0){
			System.out.println("Keine Zugmöglichkeiten, der naechste ist dran!");
			return false;
		}
		int choose = player[playerId].getPlayerDecision(possibilities.size());		//PLAYER entscheidet
		Token t = possibilities.get(choose);
		mainBoard.move(t, mainBoard.moveToken(t, roll));
		System.out.println("--------------------------");	
		return true;
	}	
}