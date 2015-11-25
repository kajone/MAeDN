package logik;



public class MainClass {

	public static void main(String[] args) {
		// Initialisiert ein Beispiel mit 2 echten Spielern und 2 Bots
		
		Player[] player = {new RealPlayer("Hans", "red",1), new RealPlayer("Kajo", "green",2),
						   new BotPlayer("Bot1", "orange",3), new BotPlayer("Bot2","violett",4)};
		
		
		GameBoard mainBoard = new GameBoard(player);
		
		mainBoard.play();
		
	}

}
