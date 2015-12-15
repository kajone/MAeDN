package logik;

import java.util.LinkedList;

public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispiel mit 2 echten Spielern und 2 Bots
		Player[] player = { new RealPlayer("Hans", "red", 1),
				new RealPlayer("Kajo", "green", 2),
				new BotPlayer("Bot1", "black", 3),
				new BotPlayer("Bot2", "violett", 4) };

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
	
	private static boolean performTurn(GameBoard mainBoard, int playerId, int roll, Player[] player){
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
