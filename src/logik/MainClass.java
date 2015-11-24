package logik;

public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispielspiel mit 2 echten Spielern und 2 Bots
		
		Player[] player = {new RealPlayer(), new RealPlayer(),
						   new BotPlayer(), new BotPlayer()};
		
		
		GameBoard mainBoard = new GameBoard(player);
		
		mainBoard.play();

	}

}
