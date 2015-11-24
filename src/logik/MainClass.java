package logik;

public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispielspiel mit 2 echten Spielern und 2 Bots
		
		Player[] player = {new RealPlayer("Hans", "blue"), new RealPlayer("Kajo", "green"),
						   new BotPlayer("Bot1", "black"), new BotPlayer("Bot2","grey")};
		
		
		GameBoard mainBoard = new GameBoard(player);
		
		mainBoard.play();

	}

}
