package logik;

public interface Player {

	
	
	public String getColor();
	
	public String getName();
	
	public int[] getPlayerMove(int[][] possibilities); 
	// �bergeben wird ein Feld aller M�glichkeiten die wieder Felder sind int[{1-4}][2]
	// Bsp.: [(2,9),(1,16),(4,3)] 
	// returnt Tupel: [Spielfigur, Spielfeld]
	// Sonderfall: Kein Zug ist M�glich
	

	
	
	
}
