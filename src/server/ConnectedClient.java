package server;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectedClient {
	private String sessionId;
	private Socket clientSocket;
	private PrintWriter output;
	private String name = "Player1";
	private String color = "red";
	private int id = 1; // 1-4 
	
	public ConnectedClient(String sessionId, Socket clientSocket) throws IOException
	{
		this.sessionId = sessionId;
		this.clientSocket = clientSocket;
		OutputStream os = clientSocket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		this.output = new PrintWriter(osw, true);

	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		
		// Je nach dem welche Farbe man gewählt hat, ändert sich die ID
		switch(color){
		case "gelb": setId(1); break;
		case "gruen": setId(2); break;
		case "rot": setId(3); break;
		case "schwarz": setId(4); break;
		default: break;
		}
		this.color = color;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void writeMessage(String msg)
	{
		output.println(msg);
		output.flush();
	}

	public String getSessionId() {
		return sessionId;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getId() {
		return id;
	}


	
	
}
