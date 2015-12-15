package logik;

import java.util.LinkedList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispiel mit 2 echten Spielern und 2 Bots
		Scanner sc = new Scanner(System.in);
		Player[] player = { new RealPlayer("Hans", "red", 1),
				new RealPlayer("Kajo", "green", 2),
				new BotPlayer("Bot1", "black", 3),
				new BotPlayer("Bot2", "violett", 4) };

		GameBoard mainBoard = new GameBoard(player);
		// mainBoard.play();
		while (true) {
			int roll;
			for (int i = 0; i < 2; i++) {
				System.out.println("player" + i + " ist dran");
				System.out.println("So sieht das Spielfeld gerade aus: ");
				System.out.println(mainBoard.toString());
				if (mainBoard.threeTimeRoll(i)) {			  // 3 Mal würfeln
					System.out.println("du darfst 3mal wuerfeln Player" + i);
					for (int j = 0; j < 3; j++) {
						roll = Integer.parseInt(sc.nextLine()); //PLAYER würfelt
						if (roll == 6) {
							System.out.println("mit der " + roll
									+ " darfst du raus");
							if(!performTurn(mainBoard, i, roll, sc)) continue;  // Wenn kein Zug möglich ist
							System.out.println("player" + i
									+ " ist nochmal dran");
							i -= 1;
							break;
							
						} else{
							System.out.println("Du hast eine " + roll
									+ " gewürfelt. Versuchs nochmal " + j + "   " + i);
						}
					}
				} else {							// normaler Zug
					roll = Integer.parseInt(sc.nextLine());      //PLAYER würfelt
					System.out.println("Du hast eine " + roll + " gewürfelt");

					if(!performTurn(mainBoard, i, roll, sc)) continue; // Wenn kein Zug möglich ist

					if (roll == 6) {
						System.out.println("player" + i
								+ " ist nochmal dran");
						i -= 1;
					}
				}
			}
		}
	}
	
	private static boolean performTurn(GameBoard mainBoard, int playerId, int roll, Scanner sc){
		LinkedList<Token> possibilities = mainBoard.getAllMoves(playerId, roll);
		for (Token t : possibilities) {
			System.out.println(t.getId());
		}
		if(possibilities.size() == 0){
			System.out.println("Keine Zugmöglichkeiten, der naechste ist dran!");
			return false;
		}
		int choose = Integer.parseInt(sc.nextLine());		//PLAYER entscheidet

		Token t = possibilities.get(choose);
		mainBoard.move(t, mainBoard.moveToken(t, roll));
		System.out.println("--------------------------");
		
		return true;
	}
	
	
}
