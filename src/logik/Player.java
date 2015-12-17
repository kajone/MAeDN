package logik;

import server.ConnectedClient;
import server.Server;

public interface Player {
	public ConnectedClient getClient();

	public String getColor();
	
	public String getName();
	
	public String toString();
	
	public int getId();
	
	public int getRollResult(Server server);
	
	public int getPlayerDecision(Server server, int intMax); 
}
