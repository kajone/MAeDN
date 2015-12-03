package logik;

import java.util.LinkedList;
import java.util.Scanner;



public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispiel mit 2 echten Spielern und 2 Bots
		Scanner sc = new Scanner(System.in);
		Player[] player = {new RealPlayer("Hans", "red",1), new RealPlayer("Kajo", "green",2),
						   new BotPlayer("Bot1", "black",3), new BotPlayer("Bot2","violett",4)};
		
		
		GameBoard mainBoard = new GameBoard(player);
//		mainBoard.play();
		while (true) {
			for (int i = 0; i < 2; i++) {
				int roll = Integer.parseInt(sc.nextLine());
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
			}
		}
		
//		File f = new File("file.txt");
//		
		
		//mainBoard.play();
//		mainBoard.mergeBoards();
//		System.out.println(mainBoard.printBoard());
	}

}
