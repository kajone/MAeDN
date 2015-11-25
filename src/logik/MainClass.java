package logik;



public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispielspiel mit 2 echten Spielern und 2 Bots
		
		Player[] player = {new RealPlayer("Hans", "blue",1), new RealPlayer("Kajo", "green",2),
						   new BotPlayer("Bot1", "black",3), new BotPlayer("Bot2","grey",4)};
		
		
		GameBoard mainBoard = new GameBoard(player);
		
		mainBoard.play();
		
	}

}
