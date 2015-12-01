package logik;

import java.io.File;



public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispiel mit 2 echten Spielern und 2 Bots
		
		Player[] player = {new RealPlayer("Hans", "red",1), new RealPlayer("Kajo", "green",2),
						   new BotPlayer("Bot1", "black",3), new BotPlayer("Bot2","violett",4)};
		
		
		
		GameTokens gameTokens = new GameTokens(player);
		System.out.println(gameTokens.toString());
		
//		File f = new File("file.txt");
//		GameBoard mainBoard = new GameBoard(player);
		
		//mainBoard.play();
//		mainBoard.mergeBoards();
//		System.out.println(mainBoard.printBoard());
	}

}
