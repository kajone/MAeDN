package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import logik.MainClass;
import server.Client;

public class SpielLobby extends JFrame implements ActionListener{
	
	private JButton spielBeitreten;
	private JButton aktualisieren;

	public SpielLobby(String titel) {

		super(titel);

		
		this.setSize(600, 600);
		getContentPane().setLayout(null);
		this.setVisible(true);
		
		spielBeitreten = new JButton("Spiel beitreten");
		spielBeitreten.setBounds(10, 240, 160, 40);
		spielBeitreten.addActionListener(this);
		getContentPane().add(spielBeitreten);
		
		aktualisieren = new JButton("aktualiesieren");
		aktualisieren.setBounds(450, 20, 120, 30);
		aktualisieren.addActionListener(this);
		getContentPane().add(aktualisieren);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == spielBeitreten){
			
			//  TODO Eingabewerte Name und Farbe über Eingabemaske 
			//  mit color chooser oder so verknuepfen
			Spielbrett brett = new Spielbrett("Spiel");	
				
	
			this.dispose();
		}
	}
}