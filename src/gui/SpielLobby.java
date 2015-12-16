package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import server.Client;

public class SpielLobby extends JFrame implements ActionListener{
	
	private JButton spielBeitreten;
	private JButton spielErstellen;
	private JButton aktualisieren;

	public SpielLobby(String titel) {

		super(titel);

		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
		
		spielBeitreten = new JButton("Spiel beitreten");
		spielBeitreten.setBounds(10, 240, 160, 40);
		spielBeitreten.addActionListener(this);
		this.add(spielBeitreten);
		
		spielErstellen = new JButton("Spiel erstellen");
		spielErstellen.setBounds(10, 320, 160, 40);
		spielErstellen.addActionListener(this);
		this.add(spielErstellen);
		
		aktualisieren = new JButton("aktualiesieren");
		aktualisieren.setBounds(450, 20, 120, 30);
		aktualisieren.addActionListener(this);
		this.add(aktualisieren);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == spielErstellen ){
			SpielErstellenEinstellungen spielErstellen = new SpielErstellenEinstellungen("Spiel erstllen");
			this.dispose();
		}	
		if(e.getSource() == spielBeitreten){
			try {
				System.out.println("Los gehts!");
				Client client = new Client(5000, "127.0.0.1");
				client.connect();
				client.writeToServer("[INIT],Jannis,blau"); //TODO Eingabewerte Name und Farbe über Eingabemaske 
															//	   mit color chooser oder so verknuepfen
			} catch (IOException e1) {
				System.out.println("Error im Client (init)");
				e1.printStackTrace();
			}
			this.dispose();
		}
	}
}