package maedn_server;

import gui.MainMenue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logik.BotPlayer;
import logik.Player;
import logik.RealPlayer;
import server.ConnectedClient;
import server.Server;



public class MainClass extends JFrame implements ActionListener {


	JLabel spielerAnzahl;
	JLabel passwort;
	JTextField spielerAnzahlEingabe;
	JTextField passwortEingabe;
	JButton erstellen;
	
	
	public static void main(String[] args) {
	
		MainClass mainMenue = new MainClass("Server");
		mainMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainMenue.setSize(400, 400);
		
		mainMenue.setLayout(null);
		mainMenue.setVisible(true);
		
	}


	public MainClass(String titel)
	{
		super(titel);
		
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
		
		spielerAnzahl = new JLabel();
		spielerAnzahl.setBounds(20, 50, 200, 40);
		spielerAnzahl.setText("Mindestanzahl Spieler(max. 4)");
		spielerAnzahl.setFont(new Font("Arial",Font.BOLD, 11));
		this.add(spielerAnzahl);
		
		passwort = new JLabel();
		passwort.setBounds(20, 150, 200, 40);
		passwort.setText("Passwort(optional)");
		passwort.setFont(new Font("Arial",Font.BOLD, 11));
		this.add(passwort);
		
		spielerAnzahlEingabe = new JTextField();
		spielerAnzahlEingabe.setBounds(350, 60, 100, 20);
		this.add(spielerAnzahlEingabe);
		
		passwortEingabe = new JTextField();
		passwortEingabe.setBounds(350, 160, 100, 20);
		this.add(passwortEingabe);
		
		erstellen = new JButton("erstellen");
		erstellen.setBounds(200, 230, 100, 20);
		erstellen.addActionListener(this);
		this.add(erstellen);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == erstellen) {
			int minSpieler =  Integer.parseInt(spielerAnzahlEingabe.getText());
			String password = passwortEingabe.getText();
			
			System.out.println("Fuer dieses Spiel sind mindestens " +minSpieler + " Spieler benoetiget.");
			if(!password.isEmpty()){
				System.out.println("Das Passwort ist: " + password);
			}
			
			// Hoster ist Server und Client in einem!
			//Server starten
			Server server = null;
			Player[] player = null;
			try {
				server = new Server(5000);
				server.start();
//				
//			     //TODO Eingabewerte Name und Farbe über Eingabemaske 
//				Thread.sleep(5000);												 //	    mit color chooser oder so verknuepfen
//				
//				// Auf minSpieler connects warten..  
				
				boolean hansWurst = true;
				while(server.getConnectedClients().size() < minSpieler){
					
					Thread.sleep(1000); // wartet 5 Sekunden
				}
			} catch (IOException | InterruptedException e1) {
				System.out.println("Error bei Server (init)");
				e1.printStackTrace();
			}
			
			// Für jeden gejointen Spieler Daten ziehen, neue Player anlegen und ab dafür
			// Ein ConnectedClient liefert deswegen Name, Farbe, Id und sich selbst an einen Player
			int playerCounter = 0;
			player = new Player[4];
			//RealPlayer erzeugen und sortiert einfuegen
			for(int i = 1; i<=server.getConnectedClients().size(); i++){
				for(ConnectedClient client : server.getConnectedClients().values()){
					if(client.getId() == i) {
						player[playerCounter] = new RealPlayer(client.getName(), client.getColor(), client.getId(), client);
						playerCounter++;
						break;
					}
				}
			}
//			// restliche BotPlayer erzeugen
			while(playerCounter < 4){
				player[playerCounter] = new BotPlayer(
						"Bot" + (playerCounter - server.getConnectedClients().size()+1), 
						(playerCounter - server.getConnectedClients().size()+1) + "",
						playerCounter+1);
				playerCounter++;
			}
			
			logik.MainClass game = new logik.MainClass(server, player); // Startet das Spiel
			this.dispose();	// Schliesst die Lobby
		}
	}

}
