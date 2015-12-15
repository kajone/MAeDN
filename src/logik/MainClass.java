package logik;

import java.util.ArrayList;
import java.util.LinkedList;

import server.ConnectedClient;
import server.Server;

public class MainClass {

	private Server s = null;
	
	public MainClass(Server s){
		this.s = s;
		play();
	}
	
	
	public void play() {
		// Initialisiert ein Spiel mit so vielen RealPlayern wie Clients angemeldet sind
		String[] name1 = {"Hans", "Kajo", "Flo", "Jannis"};
		String[] name2 = {"Bot1", "Bot2", "Bot3", "Bot4"};
		String[] color = {"red", "green", "black", "violett"};
		int playerCounter = 0;
		Player[] player = new Player[4];
		for(ConnectedClient client : s.getConnectedClients().values()){	// Init RealPlayers
			System.out.println(client.getSessionId());
			player[playerCounter] = (new RealPlayer(name1[playerCounter],color[playerCounter],playerCounter+1, client));
			playerCounter++;
		}
		for(int i = 0; playerCounter < 4; playerCounter++){	// Init BotPlayer
			player[playerCounter] = (new BotPlayer(name2[i], color[playerCounter], playerCounter+1));
			i++;
		}
	
		
		GameBoard mainBoard = new GameBoard(player);
		//System.exit(1);
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
			System.out.println(t.getId());
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