package logik;

import server.ConnectedClient;

public interface Player {
	public ConnectedClient getClient();

	public String getColor();
	
	public String getName();
	
	public String toString();
	
	public int getId();
	
	public int getRollResult();
	
	public int getPlayerDecision(int intMax); 
}
