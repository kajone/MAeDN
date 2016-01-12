package maedn_server;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	JComboBox<String> spielerAnzahlEingabe;
	JTextField passwortEingabe;
	JButton erstellen;
	String [] spieler = {"1", "2", "3", "4"};
	
	public static void main(String[] args) {
	
		MainClass mainclass = new MainClass("Server");
		mainclass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
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
		spielerAnzahl.setVisible(true);
		this.add(spielerAnzahl);
		
		passwort = new JLabel();
		passwort.setBounds(20, 150, 200, 40);
		passwort.setText("Passwort(optional)");
		passwort.setFont(new Font("Arial",Font.BOLD, 11));
		passwort.setVisible(true);
		this.add(passwort);
		
		spielerAnzahlEingabe = new JComboBox<String>(spieler);
		spielerAnzahlEingabe.setBounds(350, 60, 100, 20);
		spielerAnzahlEingabe.setVisible(true);
		this.add(spielerAnzahlEingabe);
		
		passwortEingabe = new JTextField();
		passwortEingabe.setBounds(350, 160, 100, 20);
		passwortEingabe.setVisible(true);
		this.add(passwortEingabe);
		
		erstellen = new JButton("erstellen");
		erstellen.setBounds(200, 230, 100, 20);
		erstellen.addActionListener(this);
		erstellen.setVisible(true);
		this.add(erstellen);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == erstellen) {
			int minSpieler =  Integer.parseInt((String) spielerAnzahlEingabe.getSelectedItem());
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
				
				while(server.getConnectedClients().size() < minSpieler){
					Thread.sleep(1000); // wartet eine Sekunde
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
			// Wenn mehrere die gleiche Farbe beanspruchen (entspricht gleicher id), muss auf eine freie Farbe geändert werden
//			for(int i = 1; i<=server.getConnectedClients().size(); i++){
//				for(ConnectedClient client : server.getConnectedClients().values()){
//					if(client.getId() == i) {
//						player[playerCounter] = new RealPlayer(client.getName(), client.getColor(), client.getId(), client);
//						playerCounter++;
//						break;
//					}
//				}
//			}
			
			ArrayList<String> color = new ArrayList<String>();
			color.add("gelb");color.add("gruen");color.add("rot");color.add("schwarz");
			
			for(ConnectedClient client : server.getConnectedClients().values()){
				//Wenn Platz belegt, ist scheiße
				if(player[client.getId()-1] != null && !color.contains(client.getColor())){
					// besser andere Farbe auswählen oder so
					// Wunschfarbe ist nämlich belegt, besser mal freie Farbe wählen
					client.setColor(color.get(0));
					System.out.println("RealPlayer erzeugen mit aenderung: " +client.getName()+  client.getColor()+ client.getId());
					player[client.getId()-1] = new RealPlayer(client.getName(), client.getColor(), client.getId(), client);
					color.remove(0);
					playerCounter++;
				}else{
					// Farbe ist noch frei 
					System.out.println("RealPlayer erzeugen ohne aenderung: " +client.getName()+  client.getColor()+ client.getId());
					player[client.getId()-1] = new RealPlayer(client.getName(), client.getColor(), client.getId(), client);
					color.remove(client.getColor());
					playerCounter++;
				}
			}
			// restliche BotPlayer erzeugen
			for(int i = 0; i < player.length; i++){
				if(player[i] == null){
					// Bot Player erzeugen
					System.out.println("BotPlayer erzeugen  ");
					String colorString ="";
					switch(i){
						case 0: colorString = "gelb"; break;
						case 1: colorString = "gruen"; break;
						case 2: colorString = "rot"; break;
						case 3: colorString = "schwarz"; break;
						default:System.out.println("Error Bot Initt"); break;
					}
					player[i] = new BotPlayer("Bot" + (playerCounter - server.getConnectedClients().size()+1), colorString);
					color.remove(colorString);
					playerCounter++;
				}
			}
			

			for(int i = 0; i < player.length; i++){
				System.out.println(player[i]);
			}
			

//			while(playerCounter < 4){
//				player[playerCounter] = new BotPlayer(
//						"Bot" + (playerCounter - server.getConnectedClients().size()+1), 
//						(playerCounter - server.getConnectedClients().size()+1) + "",
//						playerCounter+1);
//				playerCounter++;
//			}
			
			logik.MainClass game = new logik.MainClass(server, player); // Startet das Spiel
			this.dispose();	// Schliesst die Lobby
		}
	}

}
