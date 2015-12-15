package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logik.MainClass;
import server.Client;
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
			Server s = null;
			Client client1 = null;
			try {
				s = new Server(5000);
				s.start();
				
				client1 = new Client(5000, "127.0.0.1");
				client1.connect();
				while(true){
					// Auf minSpieler connects warten..  
					
					if(s.getConnectedClients().size() >= minSpieler){
						break;
					}		
					Thread.sleep(5000); // wartet 5 Sekunden
				}
			} catch (IOException | InterruptedException e1) {
				System.out.println("Error bei Server (init)");
				e1.printStackTrace();
			}
			
			s.writeToAll("Spiel kann los gehen, es sind " +  s.getConnectedClients().size() + " Spieler am Start!");
			// TODO Spiel kann los gehen
			//client1.writeToServer("Jeah dude");
			this.dispose();	// Schliesst die Lobby
			MainClass game = new MainClass(s);
			
			
			
		}
	}
}
