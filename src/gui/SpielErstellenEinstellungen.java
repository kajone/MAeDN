package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logik.BotPlayer;
import logik.MainClass;
import logik.Player;
import logik.RealPlayer;
import server.Client;
import server.ConnectedClient;
import server.Server;

public class SpielErstellenEinstellungen extends JFrame implements ActionListener{

	JLabel spielerAnzahl;
	JLabel passwort;
	JTextField spielerAnzahlEingabe;
	JTextField passwortEingabe;
	JButton erstellen;
	
	public SpielErstellenEinstellungen(String titel)
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
			Client clientOfHost = null;
			Player[] player = null;
			try {
				server = new Server(5000);
				server.start();
				
				clientOfHost = new Client(5000, "127.0.0.1");
				clientOfHost.connect();
				clientOfHost.writeToServer("[INIT],Kajo,gruen"); //TODO Eingabewerte Name und Farbe �ber Eingabemaske 
																 //	    mit color chooser oder so verknuepfen
				player = new Player[4];
				// Auf minSpieler connects warten..  
				while(true){
					if(server.getConnectedClients().size() >= minSpieler){
						break;
					}		
					Thread.sleep(5000); // wartet 5 Sekunden
				}
			} catch (IOException | InterruptedException e1) {
				System.out.println("Error bei Server (init)");
				e1.printStackTrace();
			}
			
			// F�r jeden gejointen Spieler Daten ziehen, neue Player anlegen und ab daf�r
			// Ein ConnectedClient liefert deswegen Name, Farbe, Id und sich selbst an einen Player
			int playerCounter = 0;
			//RealPlayer erzeugen
			for(ConnectedClient client : server.getConnectedClients().values()){
				player[playerCounter] = new RealPlayer(client.getName(), client.getColor(), client.getId(), client);
				playerCounter++;
			}
			// restliche BotPlayer erzeugen
			while(playerCounter < 4){
				player[playerCounter] = new BotPlayer(
						"Bot" + (playerCounter - server.getConnectedClients().size()+1), 
						(playerCounter - server.getConnectedClients().size()+1) + "",
						playerCounter);
				playerCounter++;
			}
			this.dispose();	// Schliesst die Lobby
			MainClass game = new MainClass(server, player); // Startet das Spiel
		}
	}
}
