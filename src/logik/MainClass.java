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
				if (mainBoard.threeTimeRoll(i)) {
					System.out.println("du darfst 3mal wuerfeln Player" + i);
					for (int j = 0; j < 3; j++) {
						roll = Integer.parseInt(sc.nextLine());
						if (roll == 6) {
							System.out.println("mit der " + roll
									+ " darfst du raus");
							LinkedList<Token> test = mainBoard.getAllMoves(i,
									roll);
							for (Token t : test) {
								System.out.println(t.getId());
							}
							int choose = Integer.parseInt(sc.nextLine());
							if (choose == -1)
								continue;
							Token t = test.get(choose);
							mainBoard.move(t, mainBoard.moveToken(t, roll));
							System.out.println("--------------------------");
							System.out.println("player" + i
									+ " ist nochmal dran");
							j +=12;
							i -= 1;
						} else{
							System.out.println("you rolled a " + roll
									+ " try again " + j + "   " + i);
						}
					}
				} else {
					roll = Integer.parseInt(sc.nextLine());
					System.out.println("you rolled a " + roll);
					LinkedList<Token> test = mainBoard.getAllMoves(i, roll);
					for (Token t : test) {
						System.out.println(t.getId());
					}
					int choose = Integer.parseInt(sc.nextLine());
					if (choose == -1)
						continue;
					Token t = test.get(choose);
					mainBoard.move(t, mainBoard.moveToken(t, roll));
					System.out.println("--------------------------");
					if (roll == 6) {
						System.out.println("darfst nochmal du penner");
						i -= 1;
					}
				}
			}
		}

	}

	// File f = new File("file.txt");
	//

	// mainBoard.play();
	// mainBoard.mergeBoards();
	// System.out.println(mainBoard.printBoard());
}


