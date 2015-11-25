package logik;

public interface Player {

	
	
	public String getColor();
	
	public String getName();
	
	public int getId();
	
	public Token[] getTokens();
	
	public int[] getPlayerMove(int[][] possibilities); 
	// Uebergeben wird ein Feld aller Moeglichkeiten die wieder Felder sind int[{0-4}][2]
	// Bsp.: [(2,9),(1,16),(4,3)] 
	// returnt Tupel: [Spielfigur, Spielfeld], Bsp: (4,3)
	// Sonderfall: Kein Zug ist moeglich
	

	
	
	
}
